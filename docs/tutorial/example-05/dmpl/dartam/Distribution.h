/*
 * distribution.h
 *
 *  Created on: Mar 11, 2015
 *      Author: gmoreno
 */

#ifndef DISTRIBUTION_H_
#define DISTRIBUTION_H_

#include <vector>

struct Distribution {
	double mean;
	double variance;
	Distribution(double mean, double variance) : mean(mean), variance(variance) {};
};

typedef std::vector<Distribution> Distributions;


#endif /* DISTRIBUTION_H_ */
