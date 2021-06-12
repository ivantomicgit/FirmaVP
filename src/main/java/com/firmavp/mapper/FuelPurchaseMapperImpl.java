package com.firmavp.mapper;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.FuelPurchaseDTO;
import com.firmavp.entity.FuelPurchase;
@Component
public class FuelPurchaseMapperImpl implements FuelPurchaseMapper{
	private final DriversMapper driversMapper;
	private final VehicleMapper vehicleMapper;
	
	

	@Autowired
	public FuelPurchaseMapperImpl(DriversMapper driversMapper, VehicleMapper vehicleMapper) {
		super();
		this.driversMapper = driversMapper;
		this.vehicleMapper = vehicleMapper;
	}

	@Override
	public FuelPurchase toFuelPurchase(@Valid FuelPurchaseDTO fuelPurchaseDTO) {
		FuelPurchase fuelPurchase = new FuelPurchase();
		fuelPurchase.setId(fuelPurchaseDTO.getId());
		fuelPurchase.setDriver(driversMapper.toDrivers(fuelPurchaseDTO.getDriver_id()));
		fuelPurchase.setLitersOfFuel(fuelPurchaseDTO.getLitersOfFuel());
		fuelPurchase.setReceiptNumber(fuelPurchaseDTO.getReceiptNumber());
		fuelPurchase.setTimeOfPurchase(fuelPurchaseDTO.getTimeOfPurchase());
		fuelPurchase.setVehicle(vehicleMapper.toVehicle(fuelPurchaseDTO.getVehicle_id()));
		return fuelPurchase;
	}

	@Override
	public FuelPurchaseDTO toFuelPurchaseDTO(FuelPurchase fuelPurchase) {
		FuelPurchaseDTO fuelPurchaseDTO = new FuelPurchaseDTO();
		fuelPurchaseDTO.setId(fuelPurchase.getId());
		fuelPurchaseDTO.setDriver_id(driversMapper.toDriversDTO(fuelPurchase.getDriver()));
		fuelPurchaseDTO.setLitersOfFuel(fuelPurchase.getLitersOfFuel());
		fuelPurchaseDTO.setReceiptNumber(fuelPurchase.getReceiptNumber());
		fuelPurchaseDTO.setTimeOfPurchase(fuelPurchase.getTimeOfPurchase());
        fuelPurchaseDTO.setVehicle_id(vehicleMapper.toVehicleDTO(fuelPurchase.getVehicle()));
		return fuelPurchaseDTO;
	}

}
