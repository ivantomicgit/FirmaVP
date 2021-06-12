package com.firmavp.controller.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firmavp.dto.VehicleMaintenanceCategoryDTO;
import com.firmavp.service.VehicleMaintenanceCategoryService;

@RestController
@RequestMapping("/api/maitenancecategory")
public class VehicleMaitenanceCategoryController {

	private final VehicleMaintenanceCategoryService vehicleMaintenanceCategoryService;

	@Autowired
	public VehicleMaitenanceCategoryController(VehicleMaintenanceCategoryService vehicleMaintenanceCategoryService) {
		super();
		this.vehicleMaintenanceCategoryService = vehicleMaintenanceCategoryService;
	}

	@PostMapping("/create")
	public ResponseEntity<VehicleMaintenanceCategoryDTO> insert(
			@RequestBody VehicleMaintenanceCategoryDTO vehicleMaitenanceCategoryDTO) {

		VehicleMaintenanceCategoryDTO vmcDTO = vehicleMaintenanceCategoryService.save(vehicleMaitenanceCategoryDTO);

		return new ResponseEntity<VehicleMaintenanceCategoryDTO>(vmcDTO, HttpStatus.OK);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<VehicleMaintenanceCategoryDTO> read(@PathVariable Integer id) {

		return new ResponseEntity<VehicleMaintenanceCategoryDTO>(
				vehicleMaintenanceCategoryService.findVehicleMaintenanceCategory(id), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<VehicleMaintenanceCategoryDTO> update(@PathVariable Integer id,
			@RequestBody VehicleMaintenanceCategoryDTO vehicleMaintenanceCategoryDTO) {

		return new ResponseEntity<VehicleMaintenanceCategoryDTO>(
				vehicleMaintenanceCategoryService.update(id, vehicleMaintenanceCategoryDTO), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {

		vehicleMaintenanceCategoryService.delete(id);
		return new ResponseEntity<String>("Maintenance category for id " + id + " is deleted", HttpStatus.OK);

	}

}
