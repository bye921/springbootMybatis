package com.example.jspritdemo.service;

import com.example.jspritdemo.dao.SolutionDao;
import com.example.jspritdemo.entity.Solution;
import com.graphhopper.jsprit.core.algorithm.VehicleRoutingAlgorithm;
import com.graphhopper.jsprit.core.algorithm.box.SchrimpfFactory;
import com.graphhopper.jsprit.core.problem.VehicleRoutingProblem;
import com.graphhopper.jsprit.core.problem.solution.VehicleRoutingProblemSolution;
import com.graphhopper.jsprit.core.util.Solutions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    SolutionDao solutionDao;

    @Override
    public void saveSolutions(List<Solution> solutions) {
        for (Solution s : solutions) {
            solutionDao.saveSolution(s);
        }
    }

    @Override
    public Collection<VehicleRoutingProblemSolution> getAllSolutions(VehicleRoutingProblem problem) {
        VehicleRoutingAlgorithm algorithm = new SchrimpfFactory().createAlgorithm(problem);
        return algorithm.searchSolutions();
    }

    @Override
    public VehicleRoutingProblemSolution bestSolution(Collection<VehicleRoutingProblemSolution> solutions) {
        return Solutions.bestOf(solutions);
    }

    @Override
    public List<Solution> editData(Collection<VehicleRoutingProblemSolution> solutions, String vehicleId) {
        int maxId = getMaxId();
        List<Solution> solutionList = new ArrayList<>();

        for (VehicleRoutingProblemSolution item : solutions) {
            Solution temp = new Solution();
            temp.setSolutionId(maxId);
            temp.setVehicleId(vehicleId);
            temp.setCost(item.getCost());
            maxId = maxId + 1;
            solutionList.add(temp);
        }
        for (Solution s : solutionList) {
            solutionDao.saveSolution(s);
        }

        return solutionList;
    }

    @Override
    public Solution editData(VehicleRoutingProblemSolution solution, String vehicleId) {
        // TODO : We should associate the best solution with the solutionList by keys, like id?
        Solution output = new Solution();
        int maxId = getMaxId();
        if (maxId > 1) maxId = maxId - 1;

        output.setSolutionId(maxId);
        output.setVehicleId(vehicleId);
        output.setCost(solution.getCost());
        return output;
    }

    private int getMaxId() {
        int maxSolutionId = 1;
        List<Solution> solutionList;
        solutionList = solutionDao.getAll();
        if (!solutionList.isEmpty()) {
            maxSolutionId = solutionDao.getMaxId() + 1;
        }
        return maxSolutionId;
    }
}
