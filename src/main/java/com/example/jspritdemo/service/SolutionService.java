package com.example.jspritdemo.service;

import com.example.jspritdemo.entity.Solution;
import com.graphhopper.jsprit.core.problem.VehicleRoutingProblem;
import com.graphhopper.jsprit.core.problem.solution.VehicleRoutingProblemSolution;

import java.util.Collection;
import java.util.List;

public interface SolutionService {

    void saveSolutions(List<Solution> solutions);

    Collection<VehicleRoutingProblemSolution> getAllSolutions(VehicleRoutingProblem problem);

    VehicleRoutingProblemSolution bestSolution(Collection<VehicleRoutingProblemSolution> solutions);

    List<Solution> editData(Collection<VehicleRoutingProblemSolution> solutions, String vehicleId);

    Solution editData(VehicleRoutingProblemSolution solution, String vehicleId);
}
