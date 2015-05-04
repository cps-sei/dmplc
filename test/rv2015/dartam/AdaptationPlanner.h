/*
 * AdaptationPlanner.h
 *
 *  Created on: Jun 25, 2014
 *      Author: gmoreno
 */

#ifndef ADAPTATIONPLANNER_H_
#define ADAPTATIONPLANNER_H_

#include <string>
#include <vector>

class AdaptationPlanner {
protected:
    std::string modelTemplatePath;

    bool generateModel(std::string environmentModel, std::string initialState, const char* modelPath);

public:
	AdaptationPlanner();

	/**
	 * Returns a vector of tactics that must be started now
	 * TODO the args should be a probability tree and a key-value map for the state
	 *
	 * @param path if not null, the temp directory path (relative) is stored there, and the
	 *   directory is not deleted
	 */
	std::vector<std::string> plan(std::string environmentModel, std::string initialState, std::string* path = 0);

	void setModelTemplatePath(const std::string& modelTemplatePath);

	virtual ~AdaptationPlanner();
	void test();
};

#endif /* ADAPTATIONPLANNER_H_ */
