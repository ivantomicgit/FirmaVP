package com.firmavp.controller.vehicles;


import java.util.HashSet;

import java.io.IOException;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.firmavp.dto.CompanyDTO;
import com.firmavp.dto.LocationDTO;
import com.firmavp.dto.VehicleDTO;

import com.firmavp.dto.VehicleDamageReportDTO;

import com.firmavp.enums.PictureCategory;
import com.firmavp.service.PicturesService;

import com.firmavp.service.VehicleService;




@RestController
@RequestMapping("/api/vehicle")
@CrossOrigin
public class VehicleController {

	private final VehicleService vehicleService;
	private final PicturesService picturesService;
	
	
	@Autowired
	public VehicleController(VehicleService vehicleService, PicturesService picturesService) {
		super();
		this.vehicleService = vehicleService;
		this.picturesService = picturesService;
	}


	@PostMapping("/create/vehicle/{idVehicleCategory}/company/{idCompany}")
	public ResponseEntity<VehicleDTO> create(@RequestBody VehicleDTO vehicleDTO, @PathVariable Integer idVehicleCategory,  @PathVariable Integer idCompany) {
		
		return new ResponseEntity<VehicleDTO>(vehicleService.save(vehicleDTO, idVehicleCategory, idCompany), HttpStatus.CREATED);

	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<VehicleDTO> read(@PathVariable Integer id) {
		
		 VehicleDTO	vehicleDTO = vehicleService.findVehicle(id);
	
		return new ResponseEntity<VehicleDTO>( vehicleDTO , HttpStatus.OK);

	}
	
	
	@GetMapping("/read/vehicle/{idCompany}")
	public ResponseEntity<List<VehicleDTO>> readVehiclesForCompanyId(@PathVariable Integer idCompany) {
		
		List<VehicleDTO> vehicleListDTO= vehicleService.findVehiclesForCompanyId(idCompany);
	
		return new ResponseEntity<List<VehicleDTO>>(vehicleListDTO , HttpStatus.OK);

	}
	
	
	@GetMapping("/readlist")
	public ResponseEntity<?> readList() {
		List<VehicleDTO> listVehicleDTO = vehicleService.findAll();

		return new ResponseEntity<List<VehicleDTO>>(listVehicleDTO, HttpStatus.OK);

	}
	
	
	@PutMapping("/update/{idVehicleCategory}/{idCompany}")
	public ResponseEntity<?> update(@RequestBody VehicleDTO vehicleDTO, @PathVariable Integer idVehicleCategory,
			@PathVariable Integer idCompany){
		
		VehicleDTO vehicleDTO1 = vehicleService.update(vehicleDTO, idVehicleCategory, idCompany);
		return new ResponseEntity<VehicleDTO>(vehicleDTO1, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {

		vehicleService.delete(id);
		return new ResponseEntity<String>("Vehicle with id "+ id + "is deleted", HttpStatus.OK);

		
	}
	
	@RequestMapping(value = "/insertPictureForVehicle", method = RequestMethod.POST,  consumes = { "multipart/form-data" })
	public ResponseEntity<String> insertPictureForVehicle(@RequestParam Integer vehicle_id, @RequestParam("files") MultipartFile [] files) throws IllegalStateException, IOException{
		
		picturesService.save(PictureCategory.VEHICLE, vehicle_id, files);
		
		
		return new ResponseEntity<String>("Pictures added.", HttpStatus.OK);
	}
	
	@GetMapping("/listOfPictures/vehicles/{vehicle_id}")
	public ResponseEntity<List<String>> findAllPicturesForProduct(@PathVariable Integer vehicle_id) {
		List<String> list = picturesService.findPicturesForEntity(PictureCategory.VEHICLE, vehicle_id);
		
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);

	}
	
	@GetMapping("/company/{idCompany}/listDamagedVehicles")
	public ResponseEntity<List<VehicleDTO>> readDamageReports(@PathVariable Integer idCompany) {
		List<VehicleDTO> listVehicleDamageReportDTO = vehicleService.findAllDamagedVehicles(idCompany);

		return new ResponseEntity<List<VehicleDTO>>(listVehicleDamageReportDTO, HttpStatus.OK);

	}
	
	@GetMapping("/company/{idCompany}/vehicle/{idVehicle}/damages")
	public ResponseEntity<VehicleDTO> findAllDamagesForVehicle(@PathVariable Integer idCompany, @PathVariable Integer idVehicle) {
		
	VehicleDTO damagedVehicleDTO = vehicleService.findAllDamagesForVehicle(idCompany, idVehicle);

		return new ResponseEntity<VehicleDTO>(damagedVehicleDTO, HttpStatus.OK);

	}
	
	
	@GetMapping("/company/{idCompany}/vehicle/{idVehicle}/damageReport/{idDamageReport}")
	public ResponseEntity<VehicleDamageReportDTO> findDamageReport(@PathVariable Integer idCompany, @PathVariable Integer idVehicle, @PathVariable Integer idDamageReport) {
		
		VehicleDamageReportDTO damagedReportDTO = vehicleService.findDamageReport(idCompany, idVehicle, idDamageReport);

		return new ResponseEntity<VehicleDamageReportDTO>(damagedReportDTO, HttpStatus.OK);

	}
		
	
	
}
