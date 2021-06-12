package com.firmavp.service;

import java.util.List;

import com.firmavp.entity.AverageFuelConsumption;
import com.firmavp.entity.Vehicle;


public interface AverageFuelConsumptionService {

	List<AverageFuelConsumption> findAll();

	AverageFuelConsumption save(AverageFuelConsumption averageFuelConsumption);

	AverageFuelConsumption findAverageFuelConsumptionById(Integer id);

	AverageFuelConsumption findAverageFuelConsumptionByVehicle(Vehicle vehicle);

}




