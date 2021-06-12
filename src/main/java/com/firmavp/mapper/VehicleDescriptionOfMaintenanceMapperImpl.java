package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.firmavp.dto.VehicleDescriptionOfMaintenanceDTO;
import com.firmavp.entity.VehicleDescriptionOfMaintenance;

@Component
public class VehicleDescriptionOfMaintenanceMapperImpl implements VehicleDescriptionOfMaintenanceMapper {

	@Override
	public List<VehicleDescriptionOfMaintenance> toListDescriptionOfMaintenance(
			List<VehicleDescriptionOfMaintenanceDTO> listVehicleMaintenanceDescriptions) {

		List<VehicleDescriptionOfMaintenance> list = new ArrayList<VehicleDescriptionOfMaintenance>();
		for (VehicleDescriptionOfMaintenanceDTO vdmDTO : listVehicleMaintenanceDescriptions) {
			VehicleDescriptionOfMaintenance vdm = new VehicleDescriptionOfMaintenance();
			vdm.setId(vdmDTO.getId());
			vdm.setDescription(vdmDTO.getDescription());
			list.add(vdm);
		}
		return list;
	}

	@Override
	public List<VehicleDescriptionOfMaintenanceDTO> toListDescriptionOfMaintenanceDTO(
			List<VehicleDescriptionOfMaintenance> listVehicleMaintenanceDescriptions) {

		List<VehicleDescriptionOfMaintenanceDTO> list = new ArrayList<VehicleDescriptionOfMaintenanceDTO>();
		for (VehicleDescriptionOfMaintenance vdm : listVehicleMaintenanceDescriptions) {
			VehicleDescriptionOfMaintenanceDTO vdmDTO = new VehicleDescriptionOfMaintenanceDTO();
			vdmDTO.setId(vdm.getId());
			vdmDTO.setDescription(vdm.getDescription());
			list.add(vdmDTO);
		}

		return list;
	}

	@Override
	public VehicleDescriptionOfMaintenance toDescriptionOfMaintenance(
			VehicleDescriptionOfMaintenanceDTO descriptionOfMaintenanceDTO) {
		VehicleDescriptionOfMaintenance vdm = new VehicleDescriptionOfMaintenance();
		vdm.setId(descriptionOfMaintenanceDTO.getId());
		vdm.setDescription(descriptionOfMaintenanceDTO.getDescription());
		//vdm.setIsDamageRepaired(descriptionOfMaintenanceDTO.getIsItDamaged());
		return vdm;
	}

	@Override
	public VehicleDescriptionOfMaintenanceDTO toDescriptionOfMaintenanceDTO(
			VehicleDescriptionOfMaintenance descriptionOfMaintenance) {
		VehicleDescriptionOfMaintenanceDTO vdmDTO = new VehicleDescriptionOfMaintenanceDTO();
		vdmDTO.setId(descriptionOfMaintenance.getId());
		vdmDTO.setDescription(descriptionOfMaintenance.getDescription());
		//vdmDTO.setIsItDamaged(descriptionOfMaintenance.getIsDamageRepaired());
		return vdmDTO;
	}

}
