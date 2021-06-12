package com.firmavp.controller.vehicles;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firmavp.dto.AverageFuelConsumptionDTO;
import com.firmavp.dto.RealFuelConsumptionDTO;
import com.firmavp.fasada.AverageFuelConsumptionFacade;



@RestController
@RequestMapping("/api/averageFuelConsumption")
@CrossOrigin
public class AverageFuelConsumptionController {
	private final AverageFuelConsumptionFacade averageFuelConsumptionFacade;

	@Autowired
	public AverageFuelConsumptionController(AverageFuelConsumptionFacade averageFuelConsumptionFacade) {
		super();
		this.averageFuelConsumptionFacade = averageFuelConsumptionFacade;
	}
	
	@GetMapping("/listOfAverageFuelConsumption")
	public ResponseEntity<List<AverageFuelConsumptionDTO>>returnListOfAllAverageFuelConsumptions(){
		List<AverageFuelConsumptionDTO> list = averageFuelConsumptionFacade.findAll();
		return new ResponseEntity<List<AverageFuelConsumptionDTO>>(list, HttpStatus.OK);
	}
	
	

	@PostMapping("/insert/vehicles/{idVehicle}")
	public ResponseEntity<AverageFuelConsumptionDTO>insertNewAverageFuelConsumption(@Valid @RequestBody AverageFuelConsumptionDTO averageFuelConsumptionDTO, @PathVariable Integer idVehicle){
		AverageFuelConsumptionDTO dto = averageFuelConsumptionFacade.save(averageFuelConsumptionDTO, idVehicle);
		return new ResponseEntity<AverageFuelConsumptionDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AverageFuelConsumptionDTO>returnsAverageFuelConsumptionDTOByGivenId(@PathVariable Integer id){
		AverageFuelConsumptionDTO dto = averageFuelConsumptionFacade.findAverageFuelConsumptionById(id);
		return new ResponseEntity<AverageFuelConsumptionDTO>(dto, HttpStatus.OK);
	}
	
	@PutMapping("/update/vehicles/{idVehicle}")
	public ResponseEntity<AverageFuelConsumptionDTO>updatesAverageFuelConsumption(@Valid @RequestBody AverageFuelConsumptionDTO averageFuelConsumptionDTO, @PathVariable Integer idVehicle){
		AverageFuelConsumptionDTO dto = averageFuelConsumptionFacade.save(averageFuelConsumptionDTO, idVehicle);
		return new ResponseEntity<AverageFuelConsumptionDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/realFuelConsumption/drivers/{idDriver}/vehicles/{idVehicle}")
	public ResponseEntity<RealFuelConsumptionDTO>calculateRealFuelConsumption(@PathVariable Integer idDriver, @PathVariable Integer idVehicle){
		RealFuelConsumptionDTO fuelConsumption = averageFuelConsumptionFacade.realFuelConsumption(idDriver, idVehicle);
		return new ResponseEntity<RealFuelConsumptionDTO>(fuelConsumption, HttpStatus.OK);
	}
	
	
	@GetMapping("/findByVehicle/vehicle/{idVehicle}")
	public ResponseEntity<AverageFuelConsumptionDTO>returnsAverageFuelConsumptionDTOByGivenVehicleId(@PathVariable Integer idVehicle){
		AverageFuelConsumptionDTO dto = averageFuelConsumptionFacade.findAverageFuelConsumptionByVehicle(idVehicle);
		return new ResponseEntity<AverageFuelConsumptionDTO>(dto, HttpStatus.OK);
	}
	





}
