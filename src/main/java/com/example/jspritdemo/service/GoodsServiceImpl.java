package com.example.jspritdemo.service;

import com.example.jspritdemo.dao.GoodsDao;
import com.example.jspritdemo.entity.Goods;
import com.example.jspritdemo.entity.Vehicle;
import com.graphhopper.jsprit.core.problem.Location;
import com.graphhopper.jsprit.core.problem.VehicleRoutingProblem;
import com.graphhopper.jsprit.core.problem.job.Shipment;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleImpl;
import com.graphhopper.jsprit.core.util.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }

    @Override
    public VehicleRoutingProblem buildRoutingProblem(VehicleImpl vehicleImpl, Vehicle vehicle, List<Goods> goods) {

        VehicleRoutingProblem problem;
        List<Shipment> shipments = new ArrayList<>();

        int shipmentId = 1;
        for (Goods good : goods) {
            Shipment shipment;
            Shipment.Builder builder = getShipmentBuilder(String.valueOf(shipmentId), vehicle.getIndex(), vehicle.getCapacity());
            shipment = builder.setPickupLocation(loc(Coordinate.newInstance(good.getPickupLocationX(), good.getPickupLocationY())))
                    .setDeliveryLocation(loc(Coordinate.newInstance(good.getDeliveryLocationX(), good.getDeliveryLocationY()))).build();
            shipments.add(shipment);
            shipmentId = shipmentId + 1;
        }

        VehicleRoutingProblem.Builder vrpBuilder = VehicleRoutingProblem.Builder.newInstance();
        vrpBuilder.addVehicle(vehicleImpl);
        vrpBuilder.addAllJobs(shipments);
        problem = vrpBuilder.build();

        return problem;
    }

    private static Shipment.Builder getShipmentBuilder(String shipmentId, int dimensionIndex, int dimensionValue) {
        return Shipment.Builder.newInstance(shipmentId).addSizeDimension(dimensionIndex, dimensionValue);
    }
    private static Location loc(Coordinate coordinate) {
        return Location.Builder.newInstance().setCoordinate(coordinate).build();
    }
}
