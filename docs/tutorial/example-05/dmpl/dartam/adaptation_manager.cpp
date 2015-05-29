/**
 * Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.

 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:

 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following acknowledgments
 * and disclaimers.

 * 2. Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution.

 * 3. The names "Carnegie Mellon University," "SEI" and/or "Software
 * Engineering Institute" shall not be used to endorse or promote
 * products derived from this software without prior written
 * permission. For written permission, please contact
 * permission@sei.cmu.edu.

 * 4. Products derived from this software may not be called "SEI" nor
 * may "SEI" appear in their names without prior written permission of
 * permission@sei.cmu.edu.

 * 5. Redistributions of any form whatsoever must retain the following
 * acknowledgment:

 * This material is based upon work funded and supported by the
 * Department of Defense under Contract No. FA8721-05-C-0003 with
 * Carnegie Mellon University for the operation of the Software
 * Engineering Institute, a federally funded research and development
 * center.

 * Any opinions, findings and conclusions or recommendations expressed
 * in this material are those of the author(s) and do not necessarily
 * reflect the views of the United States Department of Defense.

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE
 * ENGINEERING INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS"
 * BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND,
 * EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT
 * LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE
 * MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH
 * RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.

 * This material has been approved for public release and unlimited
 * distribution.

 * DM-0002494
**/

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
const char* TEMPLATE = "dartam/dart.prism";

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

