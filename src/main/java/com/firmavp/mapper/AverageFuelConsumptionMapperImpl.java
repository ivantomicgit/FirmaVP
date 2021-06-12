package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.AverageFuelConsumptionDTO;
import com.firmavp.entity.AverageFuelConsumption;



@Component
public class AverageFuelConsumptionMapperImpl implements AverageFuelConsumptionMapper {
	private final VehicleMapper vehicleMapper;
	
	
	@Autowired
	public AverageFuelConsumptionMapperImpl(VehicleMapper vehicleMapper) {
		super();
		this.vehicleMapper = vehicleMapper;
	}

	@Override
	public List<AverageFuelConsumptionDTO> toAverageFuelConsumptionDTOs(List<AverageFuelConsumption> list) {
		List<AverageFuelConsumptionDTO> listDTO = new ArrayList<AverageFuelConsumptionDTO>();
		for (AverageFuelConsumption averageFuelConsumption : list) {
			AverageFuelConsumptionDTO averageFuelConsumptionDTO = new AverageFuelConsumptionDTO();
			averageFuelConsumptionDTO.setId(averageFuelConsumption.getId());
			averageFuelConsumptionDTO.setConsumptionPerHour(averageFuelConsumption.getConsumptionPerHour());
			averageFuelConsumptionDTO.setConsumptionPer100km(averageFuelConsumption.getConsumptionPer100km());
			averageFuelConsumptionDTO.setWorkDescription(averageFuelConsumption.getWorkDescription());
			averageFuelConsumptionDTO.setNote(averageFuelConsumption.getNote());
			averageFuelConsumptionDTO.setVehicleDTO(vehicleMapper.toVehicleDTO(averageFuelConsumption.getVehicle()));
			listDTO.add(averageFuelConsumptionDTO);
		}
		return listDTO;
	}

	@Override
	public List<AverageFuelConsumption> toAverageFuelConsumptions(List<AverageFuelConsumptionDTO> listDTO) {
		List<AverageFuelConsumption> list = new ArrayList<AverageFuelConsumption>();
		for (AverageFuelConsumptionDTO averageFuelConsumptionDTO : listDTO) {
			AverageFuelConsumption averageFuelConsumption = new AverageFuelConsumption();
			averageFuelConsumption.setId(averageFuelConsumptionDTO.getId());
			averageFuelConsumption.setConsumptionPerHour(averageFuelConsumptionDTO.getConsumptionPerHour());
			averageFuelConsumption.setConsumptionPer100km(averageFuelConsumptionDTO.getConsumptionPer100km());
			averageFuelConsumption.setWorkDescription(averageFuelConsumptionDTO.getWorkDescription());
			averageFuelConsumption.setNote(averageFuelConsumptionDTO.getNote());
			averageFuelConsumption.setVehicle(vehicleMapper.toVehicle(averageFuelConsumptionDTO.getVehicleDTO()));
			list.add(averageFuelConsumption);
		}
		return list;
	}

	@Override
	public AverageFuelConsumption toAverageFuelConsumption(AverageFuelConsumptionDTO averageFuelConsumptionDTO) {
		AverageFuelConsumption averageFuelConsumption = new AverageFuelConsumption();
		averageFuelConsumption.setId(averageFuelConsumptionDTO.getId());
		averageFuelConsumption.setConsumptionPerHour(averageFuelConsumptionDTO.getConsumptionPerHour());
		averageFuelConsumption.setConsumptionPer100km(averageFuelConsumptionDTO.getConsumptionPer100km());
		averageFuelConsumption.setWorkDescription(averageFuelConsumptionDTO.getWorkDescription());
		averageFuelConsumption.setNote(averageFuelConsumptionDTO.getNote());
		averageFuelConsumption.setVehicle(vehicleMapper.toVehicle(averageFuelConsumptionDTO.getVehicleDTO()));
		return averageFuelConsumption;
	}

	@Override
	public AverageFuelConsumptionDTO toAverageFuelConsumptionDTO(AverageFuelConsumption averageFuelConsumption) {
		AverageFuelConsumptionDTO averageFuelConsumptionDTO = new AverageFuelConsumptionDTO();
		averageFuelConsumptionDTO.setId(averageFuelConsumption.getId());
		averageFuelConsumptionDTO.setConsumptionPerHour(averageFuelConsumption.getConsumptionPerHour());
		averageFuelConsumptionDTO.setConsumptionPer100km(averageFuelConsumption.getConsumptionPer100km());
		averageFuelConsumptionDTO.setWorkDescription(averageFuelConsumption.getWorkDescription());
		averageFuelConsumptionDTO.setNote(averageFuelConsumption.getNote());
		averageFuelConsumptionDTO.setVehicleDTO(vehicleMapper.toVehicleDTO(averageFuelConsumption.getVehicle()));
		return averageFuelConsumptionDTO;
	}

}



