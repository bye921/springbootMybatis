package com.example.jspritdemo.dao;

import com.example.jspritdemo.entity.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDao {
    
    Vehicle selectVehicleById(int vehicleId);
}
