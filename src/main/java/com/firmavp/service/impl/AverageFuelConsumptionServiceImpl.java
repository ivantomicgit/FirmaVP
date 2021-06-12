package com.firmavp.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.entity.AverageFuelConsumption;
import com.firmavp.entity.Vehicle;
import com.firmavp.repository.AverageFuelConsumptionRepository;
import com.firmavp.service.AverageFuelConsumptionService;


@Service
public class AverageFuelConsumptionServiceImpl implements AverageFuelConsumptionService {
	private final AverageFuelConsumptionRepository averageFuelConsumptionRepository;
	
	

	@Autowired
	public AverageFuelConsumptionServiceImpl(AverageFuelConsumptionRepository averageFuelConsumptionRepository) {
		super();
		this.averageFuelConsumptionRepository = averageFuelConsumptionRepository;
	}

	


	@Override
	@Transactional(readOnly = true)
	public List<AverageFuelConsumption> findAll() {
		
		return averageFuelConsumptionRepository.findAll();
	}




	@Override
	@Transactional
	public AverageFuelConsumption save(AverageFuelConsumption averageFuelConsumption) {
		
		return averageFuelConsumptionRepository.save(averageFuelConsumption);
	}



	@Override
	@Transactional(readOnly = true)
	public AverageFuelConsumption findAverageFuelConsumptionById(Integer id) {

		return averageFuelConsumptionRepository.findAverageFuelConsumptionById(id);
	}




	@Override
	@Transactional(readOnly = true)
	public AverageFuelConsumption findAverageFuelConsumptionByVehicle(Vehicle vehicle) {
		
		return averageFuelConsumptionRepository.findAverageFuelConsumptionByVehicle( vehicle);
	}

}
