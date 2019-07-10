package com.example.jspritdemo.service;

import com.example.jspritdemo.dao.VehicleDao;
import com.example.jspritdemo.entity.Vehicle;
import com.graphhopper.jsprit.core.problem.Location;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleImpl;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleType;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleTypeImpl;
import com.graphhopper.jsprit.core.util.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public Vehicle selectVehicleById(int vehicleId) {
        return vehicleDao.selectVehicleById(vehicleId);
    }

    @Override
    public VehicleImpl buildVehicle(Vehicle vehicle) {
        VehicleTypeImpl.Builder vehicleTypeBuilder = VehicleTypeImpl.Builder.newInstance(vehicle.getVehicleType()).addCapacityDimension(vehicle.getIndex(), vehicle.getCapacity());
        VehicleType vehicleType = vehicleTypeBuilder.build();
        VehicleImpl.Builder vehicleBuilder = VehicleImpl.Builder.newInstance(vehicle.getVehicleId());
        vehicleBuilder.setStartLocation(loc(Coordinate.newInstance(vehicle.getStart(), vehicle.getEnd())));
        vehicleBuilder.setType(vehicleType);
        return vehicleBuilder.build();
    }

    private static Location loc(Coordinate coordinate) {
        return Location.Builder.newInstance().setCoordinate(coordinate).build();
    }
}
