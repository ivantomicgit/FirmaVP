package com.firmavp.controller.vehicles;



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

import com.firmavp.dto.VehicleRegistrationDTO;
import com.firmavp.fasada.VehicleRegistrationFacade;
import com.firmavp.service.VehicleRegistrationService;

@RestController
@RequestMapping("/api/registration")
public class VehicleRegistrationController {

	
	private final VehicleRegistrationService registrationService;
	private final VehicleRegistrationFacade registrationFacade;

	public VehicleRegistrationController(VehicleRegistrationService registrationService, VehicleRegistrationFacade registrationFacade) {
		super();
		this.registrationService = registrationService;
		this.registrationFacade = registrationFacade;
	}
	
	@PostMapping("/create/{companyId}/{vehicleIid}")
	public ResponseEntity<VehicleRegistrationDTO> insert(@RequestBody VehicleRegistrationDTO vehicleRegistrationDTO, @PathVariable Integer companyId,
			@PathVariable Integer vehicleIid
			){
		
		VehicleRegistrationDTO vehicleRegistrationDTO1 = registrationFacade.save(vehicleRegistrationDTO, companyId, vehicleIid);
		
		return new ResponseEntity<VehicleRegistrationDTO>(vehicleRegistrationDTO1, HttpStatus.OK);		
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<VehicleRegistrationDTO> read(@PathVariable Integer id) {

	VehicleRegistrationDTO  vehicleRegistrationDTO = registrationService.findVehiclevehicleRegistration(id);
		
		return new ResponseEntity<VehicleRegistrationDTO>(vehicleRegistrationDTO , HttpStatus.OK);
	}
	
	@PutMapping("/update/{companyId}/{vehicleIid}")
	public ResponseEntity<?> update(@RequestBody VehicleRegistrationDTO registrationDTO,  @PathVariable Integer companyId, @PathVariable Integer vehicleIid
			){
		
		VehicleRegistrationDTO registrationDTO1 = registrationFacade.update(registrationDTO, companyId, vehicleIid);
		
		return new ResponseEntity<VehicleRegistrationDTO>(registrationDTO1, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		
		registrationService.delete(id);
		
		return new ResponseEntity<String>("Vehicle registration for id " + id + " is deleted", HttpStatus.OK);
	}
	
	
}
