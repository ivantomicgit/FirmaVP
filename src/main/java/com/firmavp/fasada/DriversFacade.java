package com.firmavp.fasada;

import java.util.List;

import javax.validation.Valid;

import com.firmavp.dto.DriversDTO;

public interface DriversFacade {

	List<DriversDTO> findAll();

	DriversDTO save(@Valid DriversDTO driversDTO);

	DriversDTO findDriversById(Integer id);

	DriversDTO addVehicleToDriver(Integer idDriver, Integer idVehicle);

}
