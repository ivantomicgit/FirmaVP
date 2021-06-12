package com.firmavp.service;

import com.firmavp.dto.VehicleMaintenanceCategoryDTO;

public interface VehicleMaintenanceCategoryService {

	VehicleMaintenanceCategoryDTO save(VehicleMaintenanceCategoryDTO vehicleMaitenanceCategoryDTO);

	VehicleMaintenanceCategoryDTO findVehicleMaintenanceCategory(Integer id);

	void delete(Integer id);

	VehicleMaintenanceCategoryDTO update(Integer id, VehicleMaintenanceCategoryDTO vehicleMaintenanceCategoryDTO);

}
