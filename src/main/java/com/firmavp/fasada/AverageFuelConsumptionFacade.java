package com.firmavp.fasada;

import java.util.List;

import javax.validation.Valid;

import com.firmavp.dto.AverageFuelConsumptionDTO;
import com.firmavp.dto.RealFuelConsumptionDTO;



public interface AverageFuelConsumptionFacade {

	List<AverageFuelConsumptionDTO> findAll();

	AverageFuelConsumptionDTO save(@Valid AverageFuelConsumptionDTO averageFuelConsumptionDTO, Integer idVehicle);

	AverageFuelConsumptionDTO findAverageFuelConsumptionById(Integer id);

	RealFuelConsumptionDTO realFuelConsumption(Integer idDriver, Integer idVehicle);

	AverageFuelConsumptionDTO findAverageFuelConsumptionByVehicle(Integer idVehicle);





}
