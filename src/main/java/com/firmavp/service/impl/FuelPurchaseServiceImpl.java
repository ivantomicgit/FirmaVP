package com.firmavp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.entity.FuelPurchase;
import com.firmavp.repository.FuelPurchaseRepository;
import com.firmavp.service.FuelPurchaseService;
@Service
public class FuelPurchaseServiceImpl implements FuelPurchaseService{
	private final FuelPurchaseRepository fuelPurchaseRepository;
	

	@Autowired
	public FuelPurchaseServiceImpl(FuelPurchaseRepository fuelPurchaseRepository) {
		super();
		this.fuelPurchaseRepository = fuelPurchaseRepository;
	}


	@Override
	@Transactional
	public FuelPurchase save(FuelPurchase fuelPurchase) {
		
		return fuelPurchaseRepository.save(fuelPurchase);
	}


	@Override
	@Transactional(readOnly = true)
	public FuelPurchase findFuelPurchaseById(Integer id) {
		
		return fuelPurchaseRepository.findFuelPurchaseById(id);
	}



	@Override
	@Transactional
	public Double allFuelPurchasedByDriverAndVehicle(Integer idDriver, Integer idVehicle) {
		
		return fuelPurchaseRepository.allFuelPurchasedByDriverAndVehicle(idDriver, idVehicle);
	}

}
