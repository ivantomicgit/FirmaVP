package com.firmavp.fasada;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.firmavp.dto.FuelPurchaseDTO;
import com.firmavp.dto.VehicleDTO;
import com.firmavp.entity.Drivers;
import com.firmavp.entity.FuelPurchase;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.DriversMapper;
import com.firmavp.mapper.FuelPurchaseMapper;
import com.firmavp.service.DriversService;
import com.firmavp.service.FuelPurchaseService;
import com.firmavp.service.VehicleService;

@Component
public class FuelPurchaseFacadeImpl implements FuelPurchaseFacade{
	private final FuelPurchaseService fuelPurchaseService;
	private final FuelPurchaseMapper fuelPurchaseMapper;
	private final VehicleService vehicleService;
	private final DriversService driversService;
	private final DriversMapper driversMapper;
	
	

	@Autowired
	public FuelPurchaseFacadeImpl(FuelPurchaseService fuelPurchaseService, FuelPurchaseMapper fuelPurchaseMapper,
			VehicleService vehicleService, DriversService driversService, DriversMapper driversMapper) {
		super();
		this.fuelPurchaseService = fuelPurchaseService;
		this.fuelPurchaseMapper = fuelPurchaseMapper;
		this.vehicleService = vehicleService;
		this.driversService = driversService;
		this.driversMapper = driversMapper;
	}


	@Override
	public FuelPurchaseDTO save(@Valid FuelPurchaseDTO fuelPurchaseDTO, Integer idVehicle, Integer idDriver) {
		VehicleDTO vehicleDTO = null;
		try {
			vehicleDTO = vehicleService.findVehicle(idVehicle);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withError_code(HttpStatus.NOT_FOUND.name()).withMessage("").withDetail("Vehicle with id" + idVehicle + "not found.").build();
		}
		Drivers drivers = null;
		try {
			drivers = driversService.findDriversById(idDriver);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withError_code(HttpStatus.NOT_FOUND.name()).withMessage("").withDetail("Drivers with id " + idDriver + " not found.").build();
		}
		fuelPurchaseDTO.setDriver_id(driversMapper.toDriversDTO(drivers));
		fuelPurchaseDTO.setVehicle_id(vehicleDTO);
		FuelPurchase fuelPurchase = fuelPurchaseMapper.toFuelPurchase(fuelPurchaseDTO);
		fuelPurchase = fuelPurchaseService.save(fuelPurchase);
		return fuelPurchaseMapper.toFuelPurchaseDTO(fuelPurchase);
	}



	



	@Override
	public FuelPurchaseDTO findFuelPurchaseById(Integer id) {
		FuelPurchase fuelPurchase = null;
		try {
			fuelPurchase = fuelPurchaseService.findFuelPurchaseById(id);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withError_code(HttpStatus.NOT_FOUND.name()).withMessage("").withDetail("Fuel purchase with id " + id + " not found.").build();
		}
		return fuelPurchaseMapper.toFuelPurchaseDTO(fuelPurchase);
	}

}
