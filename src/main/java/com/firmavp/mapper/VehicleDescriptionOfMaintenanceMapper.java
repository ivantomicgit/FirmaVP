package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.VehicleDescriptionOfMaintenanceDTO;
import com.firmavp.entity.VehicleDescriptionOfMaintenance;

public interface VehicleDescriptionOfMaintenanceMapper {

	List<VehicleDescriptionOfMaintenance> toListDescriptionOfMaintenance(
			List<VehicleDescriptionOfMaintenanceDTO> listVehicleMaintenanceDescriptions);

	List<VehicleDescriptionOfMaintenanceDTO> toListDescriptionOfMaintenanceDTO(
			List<VehicleDescriptionOfMaintenance> listVehicleMaintenanceDescriptions);

	VehicleDescriptionOfMaintenance toDescriptionOfMaintenance(
			VehicleDescriptionOfMaintenanceDTO descriptionOfMaintenanceDTO);

	VehicleDescriptionOfMaintenanceDTO toDescriptionOfMaintenanceDTO(
			VehicleDescriptionOfMaintenance descriptionOfMaintenance);

}
