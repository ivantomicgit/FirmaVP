package com.firmavp.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.entity.Drivers;
import com.firmavp.entity.Vehicle;
import com.firmavp.repository.DriversRepository;
import com.firmavp.service.DriversService;
@Service
public class DriversServiceImpl implements DriversService {
	private final DriversRepository driversRepository;
	
	

	@Autowired
	public DriversServiceImpl(DriversRepository driversRepository) {
		super();
		this.driversRepository = driversRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Drivers> findAll() {
		
		return driversRepository.findAll();
	}

	@Override
	@Transactional
	public Drivers save(Drivers drivers) {
		
		return driversRepository.save(drivers);
	}

	@Override
	@Transactional(readOnly = true)
	public Drivers findDriversById(Integer id) {
		
		return driversRepository.findDriversById(id);
	}

	@Override
	@Transactional
	public Drivers addVehicleToDriver(Drivers drivers, Vehicle vehicle) {
		if (drivers.getVehicles()== null) {
			drivers.setVehicles(new HashSet<Vehicle>());
		}
		if (vehicle.getDrivers()== null) {
			vehicle.setDrivers(new HashSet<Drivers>());
		}
		drivers.addVehicle(vehicle);
		
		return driversRepository.save(drivers);
	}

}
