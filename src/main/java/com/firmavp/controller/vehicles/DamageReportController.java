package com.firmavp.controller.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firmavp.dto.VehicleDamageReportDTO;
import com.firmavp.service.VehicleDamageReportService;

@RestController
@RequestMapping("/api/damageReport")
public class DamageReportController {

	private final VehicleDamageReportService vehicleDamageReportService;
	
	@Autowired
	public DamageReportController(VehicleDamageReportService vehicleDamageReportService) {
		super();
		this.vehicleDamageReportService = vehicleDamageReportService;
	}


//	@PostMapping("/reapair/{idVehicle}")
//	public ResponseEntity<?> repair(@RequestBody VehicleDamageReportDTO vehicleDamageReportDTO, @PathVariable Integer idVehicle) {
//		
//		//VehicleDamageReportDTO vehicleDamageReportDTO1 = vehicleService.repair(vehicleDamageReportDTO, idVehicle);
//		
//		return new ResponseEntity<VehicleDamageReportDTO>(vehicleDamageReportService.repair(vehicleDamageReportDTO, idVehicle), HttpStatus.OK);
//
//	}
	
	
	
	
	
}
