package com.firmavp.controller.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.firmavp.dto.VehicleDescriptionOfMaintenanceDTO;
import com.firmavp.service.VehicleDescriptionOfMaintenanceService;

@RestController
@RequestMapping("/api/vehicle/descriptionOfMaintenance")
public class VehicleDescriptionOfMaintenanceController {

	private final VehicleDescriptionOfMaintenanceService descriptionOfMaintenanceService;
	
	
	
	@Autowired
	public VehicleDescriptionOfMaintenanceController(
			VehicleDescriptionOfMaintenanceService descriptionOfMaintenanceService) {
		super();
		this.descriptionOfMaintenanceService = descriptionOfMaintenanceService;
	}


	@PostMapping("/vehicle/{idVehicle}/maintenanceCategory/{idMaintenanceCategory}/damageReport/{idDamageReport}")
	public ResponseEntity<?> repair(@RequestBody VehicleDescriptionOfMaintenanceDTO descriptionOfMaintenanceDTO, @PathVariable Integer idVehicle,
			@PathVariable Integer idMaintenanceCategory, @PathVariable Integer idDamageReport) {
		
		return new ResponseEntity<VehicleDescriptionOfMaintenanceDTO>(descriptionOfMaintenanceService.repair(descriptionOfMaintenanceDTO,idVehicle,idMaintenanceCategory, idDamageReport ), HttpStatus.OK);

	}
}
