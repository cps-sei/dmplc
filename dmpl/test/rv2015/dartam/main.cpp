/*
 * main.cpp
 *
 *  Created on: Mar 11, 2015
 *      Author: gmoreno
 */

#include "adaptation_manager.h"
#include "Distribution.h"
#include <cstdlib>
#include <iostream>
#include <math.h>

using namespace std;

// velocity
const double V[] = { 5.0, 2.0};

const int TOTAL_SEGMENTS = 8;
const double SEGMENT_LENGTH = 1.0;


int main() {
	double flyTime = (TOTAL_SEGMENTS * SEGMENT_LENGTH) * (1 / V[0] + 1 / V[1]) / 2;

	// set up environment
	srand(1); // seed
	Distributions environment;
	for (int s = 0; s < TOTAL_SEGMENTS; s++) {
		double mean = ((double)rand()) / RAND_MAX;
		environment.push_back(Distribution(mean, 1));
	}

	double position = 0;
	int formation = 0;

	while (position < TOTAL_SEGMENTS * SEGMENT_LENGTH) {

		unsigned currentSegment = floor(position / SEGMENT_LENGTH);

		cout << "@segment " << currentSegment + 1
				<< " position=" << position
				<< " formation= " << formation
				<< " remaining fly time=" << flyTime << endl;


		double hazards[5];
		double variances[5];
		cout << "@env";
		for (unsigned i = 0; i < 5; i++) {
			if (currentSegment + 1 + i > environment.size()) {
				hazards[i] = 0;
				variances[i] = 0;
			} else {
				hazards[i] = environment[currentSegment + 1 + i].mean;
				variances[i] = environment[currentSegment + 1 + i].variance;
			}
			cout << '(' << hazards[i] << ',' << variances[i] << ')';
		}
		cout << endl;

		formation = adaptation_manager(
				formation,
				0, //int changing, //-- whether in process of changing to other formation
				0, // double change_progress, //-- progress in changing to other formation (remaining time)
				hazards[0],
				hazards[1],
				hazards[2],
				hazards[3],
				hazards[4],
				variances[0],
				variances[1],
				variances[2],
				variances[3],
				variances[4],
				V[0],
				V[1],
				SEGMENT_LENGTH,
				TOTAL_SEGMENTS - currentSegment,
				flyTime
		);

		// advance one segment per period
		position += SEGMENT_LENGTH;
		flyTime -= SEGMENT_LENGTH / V[formation];
		if (flyTime < -1e-10) {
			cout << "@Ran out of fuel, fly time = " << flyTime << endl;
			return EXIT_FAILURE;
		}
	}
	cout << "@Success!" << endl;
	return EXIT_SUCCESS;
}
