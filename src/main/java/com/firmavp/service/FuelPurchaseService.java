package com.firmavp.service;

import com.firmavp.entity.FuelPurchase;

public interface FuelPurchaseService {

	FuelPurchase save(FuelPurchase fuelPurchase);

	FuelPurchase findFuelPurchaseById(Integer id);

	Double allFuelPurchasedByDriverAndVehicle(Integer idDriver, Integer idVehicle);

}
