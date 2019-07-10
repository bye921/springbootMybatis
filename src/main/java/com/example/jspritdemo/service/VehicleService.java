package com.example.jspritdemo.service;

import com.example.jspritdemo.entity.Vehicle;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleImpl;

public interface VehicleService {

    Vehicle selectVehicleById(int vehicleId);

    VehicleImpl buildVehicle(Vehicle vehicle);
}
