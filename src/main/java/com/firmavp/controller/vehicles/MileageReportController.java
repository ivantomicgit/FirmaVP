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

import com.firmavp.dto.MileageReportDTO;
import com.firmavp.enums.PictureCategory;
import com.firmavp.fasada.MileageReportFacade;
import com.firmavp.service.PicturesService;

@RestController
@RequestMapping("/api/mileageReport")
@CrossOrigin
public class MileageReportController {
	private final MileageReportFacade mileageReportFacade;
	private final PicturesService picturesService;

	@Autowired
	public MileageReportController(MileageReportFacade mileageReportFacade, PicturesService picturesService) {
		super();
		this.mileageReportFacade = mileageReportFacade;
		this.picturesService = picturesService;
	}
	
	@PostMapping("/insert/vehicles/{idVehicle}")
	public ResponseEntity<MileageReportDTO>insertNewMileageReport(@Valid @RequestBody MileageReportDTO mileageReportDTO, @PathVariable Integer idVehicle){
		MileageReportDTO dto = mileageReportFacade.save(mileageReportDTO, idVehicle);
		return new ResponseEntity<MileageReportDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MileageReportDTO>returnsMileageReportDTOByGivenId(@PathVariable Integer id){
		MileageReportDTO dto = mileageReportFacade.findMileageReportById(id);
		return new ResponseEntity<MileageReportDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/byVehicle/vehicles/{idVehicle}")
	public ResponseEntity<List<MileageReportDTO>>returnsMileageReportDTOByGivenVehicleId(@PathVariable Integer idVehicle){
		List<MileageReportDTO> dto = mileageReportFacade.findMileageReportByVehicle__Id(idVehicle);
		return new ResponseEntity<List<MileageReportDTO>>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/insertPictureForMileageReport", method = RequestMethod.POST,  consumes = { "multipart/form-data" })
	public ResponseEntity<String> insertPictureForMileageReport(@RequestParam Integer mileage_report_id, @RequestParam("files") MultipartFile [] files) throws IllegalStateException, IOException{
		
		picturesService.save(PictureCategory.MILEAGE_REPORT, mileage_report_id, files);
		
		
		return new ResponseEntity<String>("Pictures added.", HttpStatus.OK);
	}
	
	@GetMapping("/listOfPictures/mileageReport/{mileage_report_id}")
	public ResponseEntity<List<String>> findAllPicturesForProduct(@PathVariable Integer mileage_report_id) {
		List<String> list = picturesService.findPicturesForEntity(PictureCategory.MILEAGE_REPORT, mileage_report_id);
		
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);

	}

}
