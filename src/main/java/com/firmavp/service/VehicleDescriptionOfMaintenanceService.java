package com.firmavp.service;

import com.firmavp.dto.VehicleDescriptionOfMaintenanceDTO;

public interface VehicleDescriptionOfMaintenanceService {

	VehicleDescriptionOfMaintenanceDTO repair(VehicleDescriptionOfMaintenanceDTO descriptionOfMaintenanceDTO,
			Integer idVehicle, Integer idMaintenanceCategory, Integer idDamageReport);

}
