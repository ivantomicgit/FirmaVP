package com.firmavp.service;

import java.util.List;

import com.firmavp.entity.Drivers;
import com.firmavp.entity.Vehicle;


public interface DriversService {

	List<Drivers> findAll();

	Drivers save(Drivers drivers);

	Drivers findDriversById(Integer id);

	Drivers addVehicleToDriver(Drivers drivers, Vehicle vehicle);

	
}
