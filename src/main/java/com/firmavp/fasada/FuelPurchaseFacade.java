package com.firmavp.fasada;

import javax.validation.Valid;

import com.firmavp.dto.FuelPurchaseDTO;

public interface FuelPurchaseFacade {

	FuelPurchaseDTO save(@Valid FuelPurchaseDTO fuelPurchaseDTO, Integer idVehicle, Integer idDriver);

	FuelPurchaseDTO findFuelPurchaseById(Integer id);

}
