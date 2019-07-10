package com.example.jspritdemo.controller;

import com.example.jspritdemo.entity.Goods;
import com.example.jspritdemo.entity.Solution;
import com.example.jspritdemo.entity.Vehicle;
import com.example.jspritdemo.service.GoodsService;
import com.example.jspritdemo.service.SolutionService;
import com.example.jspritdemo.service.VehicleService;
import com.graphhopper.jsprit.core.problem.VehicleRoutingProblem;
import com.graphhopper.jsprit.core.problem.solution.VehicleRoutingProblemSolution;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class InitController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    SolutionService solutionService;

    @RequestMapping("/")
    public String init(Model model) {

        // get Vehicle
        Vehicle vehicle = vehicleService.selectVehicleById(101);

        // get all goods
        List<Goods> goods = goodsService.getAllGoods();

        model.addAttribute("vehicle", vehicle);
        model.addAttribute("goods", goods);

        return "index";
    }

    @RequestMapping("/getBest")
    public String getBestSolution(Model model) {

        VehicleImpl vehicleImpl;

        // get Vehicle
        Vehicle vehicle = vehicleService.selectVehicleById(101);

        // get all goods
        List<Goods> goods = goodsService.getAllGoods();

        vehicleImpl = vehicleService.buildVehicle(vehicle);

        VehicleRoutingProblem problem = goodsService.buildRoutingProblem(vehicleImpl, vehicle, goods);

        Collection<VehicleRoutingProblemSolution> solutions = solutionService.getAllSolutions(problem);
        List<Solution> solutionList = solutionService.editData(solutions, vehicle.getVehicleId());

        // TODO : We should associate the best solution with the solutionList by keys, like id?
        VehicleRoutingProblemSolution bestSolution = solutionService.bestSolution(solutions);
        Solution best = solutionService.editData(bestSolution, vehicle.getVehicleId());

        model.addAttribute("solutions", solutionList);
        model.addAttribute("best", best);
        return "solutions";
    }
}
