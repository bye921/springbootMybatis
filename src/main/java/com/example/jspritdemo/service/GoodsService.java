package com.example.jspritdemo.service;

import com.example.jspritdemo.entity.Goods;
import com.example.jspritdemo.entity.Vehicle;
import com.graphhopper.jsprit.core.problem.VehicleRoutingProblem;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleImpl;

import java.util.List;

public interface GoodsService {

    List<Goods> getAllGoods();

    VehicleRoutingProblem buildRoutingProblem(VehicleImpl vehicleImpl, Vehicle vehicle, List<Goods> goods);
}
