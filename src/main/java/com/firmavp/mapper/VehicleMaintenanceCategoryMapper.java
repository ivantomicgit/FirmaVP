package com.firmavp.mapper;

import com.firmavp.dto.VehicleMaintenanceCategoryDTO;
import com.firmavp.entity.VehicleMaintenanceCategory;

public interface VehicleMaintenanceCategoryMapper {

	VehicleMaintenanceCategory toVehicleMaintenanceCategory(VehicleMaintenanceCategoryDTO vehicleMaitenanceCategoryDTO);

	VehicleMaintenanceCategoryDTO toVehicleMaintenanceCategoryDTO(VehicleMaintenanceCategory vmc);

}
