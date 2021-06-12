package com.firmavp.controller.vehicles;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.firmavp.dto.VehicleDamageReportDTO;
import com.firmavp.enums.PictureCategory;
import com.firmavp.fasada.VehicleDamageReportFacade;
import com.firmavp.service.PicturesService;

@RestController
@RequestMapping("/api/damageReport")
@CrossOrigin
public class VehicleDamageReportController {
	private final VehicleDamageReportFacade vehicleDamageReportFacade;
	private final PicturesService picturesService;

	@Autowired
	public VehicleDamageReportController(VehicleDamageReportFacade vehicleDamageReportFacade, PicturesService picturesService) {
		super();
		this.vehicleDamageReportFacade = vehicleDamageReportFacade;
		this.picturesService = picturesService;
	}
	

	
	@GetMapping("/{id}")
	public ResponseEntity<VehicleDamageReportDTO>findVehicleDamageReporByGivenId(@PathVariable Integer id){
		VehicleDamageReportDTO vehicleDamageReportDTO = vehicleDamageReportFacade.findVehicleDamageReportById(id);
		return new ResponseEntity<VehicleDamageReportDTO>(vehicleDamageReportDTO, HttpStatus.OK);
	}
	


	@GetMapping("/findReportForVehicle/vehicles/{idVehicle}")
	public ResponseEntity<List<VehicleDamageReportDTO>>findAllVehicleDamageReportsForGivenVehicleId(@PathVariable Integer idVehicle){
		List<VehicleDamageReportDTO>list = vehicleDamageReportFacade.findVehicleDamageReportByVehicleId(idVehicle);
		return new ResponseEntity<List<VehicleDamageReportDTO>>(list, HttpStatus.OK);
	}

	
	

	@RequestMapping(value = "/insertPictureForVehicleDamageReport", method = RequestMethod.POST,  consumes = { "multipart/form-data" })
	public ResponseEntity<String> insertPictureForVehicleDamageReport(@RequestParam Integer vehicle_damage_report_id, @RequestParam("files") MultipartFile [] files) throws IllegalStateException, IOException{
		
		picturesService.save(PictureCategory.VEHICLE_DAMAGE_REPORT, vehicle_damage_report_id, files);
		
		
		return new ResponseEntity<String>("Pictures added.", HttpStatus.OK);
	}


	@GetMapping("/listOfPictures/vehicleDamageReport/{vehicle_damage_report_id}")
	public ResponseEntity<List<String>> findAllPicturesForProduct(@PathVariable Integer vehicle_damage_report_id) {
		List<String> list = picturesService.findPicturesForEntity(PictureCategory.VEHICLE_DAMAGE_REPORT, vehicle_damage_report_id);
		
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);

	}
}
