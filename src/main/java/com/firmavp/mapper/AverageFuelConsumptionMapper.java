package com.firmavp.mapper;


import java.util.List;

import com.firmavp.dto.AverageFuelConsumptionDTO;
import com.firmavp.entity.AverageFuelConsumption;



public interface AverageFuelConsumptionMapper {

	List<AverageFuelConsumptionDTO> toAverageFuelConsumptionDTOs(List<AverageFuelConsumption> list);
	List<AverageFuelConsumption>toAverageFuelConsumptions(List<AverageFuelConsumptionDTO> listDTO);
	AverageFuelConsumption toAverageFuelConsumption(AverageFuelConsumptionDTO potrosnjaGorivaDTO);
	AverageFuelConsumptionDTO toAverageFuelConsumptionDTO(AverageFuelConsumption averageFuelConsumption);





}
