package com.firmavp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.AverageFuelConsumption;
import com.firmavp.entity.Vehicle;



@Repository
public interface AverageFuelConsumptionRepository extends JpaRepository<AverageFuelConsumption, Integer> {

	AverageFuelConsumption findAverageFuelConsumptionById(Integer id);

	AverageFuelConsumption findAverageFuelConsumptionByVehicle(Vehicle vehicle);

}



