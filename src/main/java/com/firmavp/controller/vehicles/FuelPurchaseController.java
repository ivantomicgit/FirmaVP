package com.firmavp.controller.vehicles;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.firmavp.dto.FuelPurchaseDTO;
import com.firmavp.enums.PictureCategory;
import com.firmavp.fasada.FuelPurchaseFacade;
import com.firmavp.service.PicturesService;

@RestController
@RequestMapping("/api/fuelPurchase")
@CrossOrigin
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DRIVER')")
public class FuelPurchaseController {
	private final FuelPurchaseFacade fuelPurchaseFacade;
	private final PicturesService picturesService;

	@Autowired
	public FuelPurchaseController(FuelPurchaseFacade fuelPurchaseFacade, PicturesService picturesService) {
		super();
		this.fuelPurchaseFacade = fuelPurchaseFacade;
		this.picturesService = picturesService;
	}
	
	@PostMapping("/insert/vehicles/{idVehicle}/drivers/{idDriver}")
	public ResponseEntity<FuelPurchaseDTO>insertNewFuelPurchase(@Valid @RequestBody FuelPurchaseDTO fuelPurchaseDTO, @PathVariable Integer idVehicle, @PathVariable Integer idDriver){
		FuelPurchaseDTO DTO = fuelPurchaseFacade.save(fuelPurchaseDTO, idVehicle, idDriver);
		
		return new ResponseEntity<FuelPurchaseDTO>(DTO, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuelPurchaseDTO>returnsFuelPurchaseDTOByGivenId(@PathVariable Integer id){
		FuelPurchaseDTO fuelPurchaseDTO = fuelPurchaseFacade.findFuelPurchaseById(id);
		return new ResponseEntity<FuelPurchaseDTO>(fuelPurchaseDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/insertPictureForFuelPurchase", method = RequestMethod.POST,  consumes = { "multipart/form-data" })
	public ResponseEntity<String> insertPictureForFuelPurchase(@RequestParam Integer fuel_purchase_id, @RequestParam("files") MultipartFile [] files) throws IllegalStateException, IOException{
		
		picturesService.save(PictureCategory.FUEL_PURCHASE, fuel_purchase_id, files);
		
		
		return new ResponseEntity<String>("Pictures added.", HttpStatus.OK);
	}
	
	@GetMapping("/listOfPictures/fuelPurchase/{fuel_purchase_id}")
	public ResponseEntity<List<String>> findAllPicturesForProduct(@PathVariable Integer fuel_purchase_id) {
		List<String> list = picturesService.findPicturesForEntity(PictureCategory.FUEL_PURCHASE, fuel_purchase_id);
		
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);

	}
	
	

}
