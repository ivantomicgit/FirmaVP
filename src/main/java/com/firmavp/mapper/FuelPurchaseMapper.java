package com.firmavp.mapper;

import javax.validation.Valid;

import com.firmavp.dto.FuelPurchaseDTO;
import com.firmavp.entity.FuelPurchase;

public interface FuelPurchaseMapper {

	FuelPurchase toFuelPurchase(@Valid FuelPurchaseDTO fuelPurchaseDTO);

	FuelPurchaseDTO toFuelPurchaseDTO(FuelPurchase fuelPurchase);

}
