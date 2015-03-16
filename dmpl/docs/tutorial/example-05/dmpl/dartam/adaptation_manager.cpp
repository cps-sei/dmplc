/*
 * adaptation_manager.cpp
 *
 *  Created on: Mar 6, 2015
 *      Author: gmoreno
 */
#include "adaptation_manager.h"
#include "AdaptationPlanner.h"
#include <assert.h>
#include <math.h>
#include <sstream>
#include <iostream>
#include "Distribution.h"

using namespace std;

const double EXPOSURE_LOOSE = 0.8;
const double EXPOSURE_TIGHT = 0.2;
const char* TEMPLATE = "dart.prism";

const char* SWITCH_TO_TIGHT = "switchToTight_start";
const char* SWITCH_TO_LOOSE = "switchToLoose_start";

const char* STATE_VAR = "s";

// for Extended Pearson-Tukey
const double P_QUANTILE = 0.185;
const double QUANTILE = 1.644854;



/**
 * input is a sequence of independent distributions
 * The output DTMC has a initial state for the current time,
 * and three states for each distribution. All states for a time have
 * transitions to all the states in the following time.
 */
string generateEnvironmentModel(Distributions predictions) {

	/*
	 * [tick] s = 0 -> P_QUANTILE : (s' = ceil(s / 3));
	 * [tick] s = 5 - 1 -> 1 : true;
	 */


	stringstream ss;
	int numberOfStates = 1 + predictions.size() * 3; // three branches

	ss << "const double P_QUANTILE = " << P_QUANTILE << ';' << endl;
	ss << "module env" << endl;
	ss << STATE_VAR << " : [0.." << numberOfStates - 1 << "] init 0;" << endl;

	ss << "[tick] " << STATE_VAR << " < " << numberOfStates - 3
			<< " -> P_QUANTILE : (s' = (floor(s/3) * 3 + 1))"
			" + (1 - 2 * P_QUANTILE) : (s' = (floor(s/3) * 3 + 2))"
			" + P_QUANTILE : (s' = (floor(s/3) * 3 + 3));" << endl;
	ss << "[tick] " << STATE_VAR << " >= " << numberOfStates - 3
			<< " -> true;" << endl;
	ss << "endmodule" << endl;
	ss << "formula stateValue = " << endl;
	for (unsigned t = 0; t < predictions.size(); t++) {
		double sd = sqrt(predictions[t].variance);
		for (int q = -1; q <= 1; q++) {
			double value = max(predictions[t].mean + q * QUANTILE * sd , 0.0);
			ss << '(' << STATE_VAR << '=' << (t * 3) + q + 2 << '?'
					<< value  << " : 0) +" << endl;
		}
	}
	ss << "0;" << endl;
	return ss.str();
}

int adaptation_manager
(
 int current_formation, //-- 0 loose, 1 tight
 int changing, //-- whether in process of changing to other formation
 double change_progress, //-- progress in changing to other formation (remaining time)
 //-- next n hazards (for the next n segments in the path)
 double hazard1,
 double hazard2,
 double hazard3,
 double hazard4,
 double hazard5,
 //-- variance of the next n hazards predictions
 double variance1,
 double variance2,
 double variance3,
 double variance4,
 double variance5,
 double loose_speed, //-- speed of loose formation
 double tight_speed, //-- speed of tight formation
 double segment_length, //-- length of a segment in the path
 int remaining_segments, //-- number of segments remaining in the path
 double remaining_flight_time //-- how much flight time the formation has left
) {
	bool debug = true; // true to save a copy of the expanded template
	int formation = current_formation; // returning the same means no change (even if in progress)

	if (changing) {

		// for now, the only tactic is changing formation, so no need to evaluate
		return formation;
	}

	assert(loose_speed > tight_speed);

	// build initial state code
    stringstream initialState;
    initialState << "const double V_0 = " << loose_speed << ";" << endl;
    initialState << "const double V_1 = " << tight_speed << ";" << endl;
    initialState << "const double E_0 = " << EXPOSURE_LOOSE << ";" << endl;
    initialState << "const double E_1 = " << EXPOSURE_TIGHT << ";" << endl;
    initialState << "const double SL = " << segment_length << ";" << endl;
    initialState << "const int N = " << remaining_segments << ";" << endl;
    initialState << "const double T = " << remaining_flight_time << ";" << endl;
    initialState << "const int ini_config = " << current_formation << ";" << endl;

    // get environment model
    Distributions predictions;
    predictions.push_back(Distribution(hazard1, variance1));
    predictions.push_back(Distribution(hazard2, variance2));
    predictions.push_back(Distribution(hazard3, variance3));
    predictions.push_back(Distribution(hazard4, variance4));
    predictions.push_back(Distribution(hazard5, variance5));
    string environmentModel = generateEnvironmentModel(predictions);


    AdaptationPlanner planner;
    planner.setModelTemplatePath(TEMPLATE);
    string* pPath = 0;
    if (debug) {
        pPath = new string;
    }
    vector<string> actions = planner.plan(environmentModel, initialState.str(), pPath);
    if (pPath) {
        cout << "*debug path " << *pPath << endl;
        delete pPath;
    }

    int newFormation = -1; // default to noop
    for (vector<string>::iterator it = actions.begin(); it != actions.end(); it++) {
        if (*it == SWITCH_TO_TIGHT) {
        	assert(newFormation == -1);
        	newFormation = 1;
            cout << "@SWITCH_TO_TIGHT" << endl;
        } else if (*it == SWITCH_TO_LOOSE) {
        	assert(newFormation == -1);
        	newFormation = 0;
        	cout << "@SWITCH_TO_LOOSE" << endl;
        }
    }

    if (newFormation != -1) {
    	formation = newFormation;
    } else {
    	cout << "@noop" << endl;
    }

	return formation;
}

