package com.firmavp.controller.employee;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firmavp.dto.DriversDTO;
import com.firmavp.dto.VehicleDamageReportDTO;
import com.firmavp.fasada.DriversFacade;
import com.firmavp.fasada.VehicleDamageReportFacade;

@RestController
@RequestMapping("/api/drivers")
@CrossOrigin
public class DriversController {
	private final DriversFacade driverFacade;
	private final VehicleDamageReportFacade vehicleDamageReportFacade;
	

	@Autowired
	public DriversController(DriversFacade driverFacade, VehicleDamageReportFacade vehicleDamageReportFacade) {
		super();
		this.driverFacade = driverFacade;
		this.vehicleDamageReportFacade = vehicleDamageReportFacade;
	}

	@GetMapping("/listOfDrivers")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<DriversDTO>>returnListOfAllDrivers(){
		List<DriversDTO> workplaces = driverFacade.findAll();
		return new ResponseEntity<List<DriversDTO>>(workplaces, HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<DriversDTO>insertNewDriver(@Valid @RequestBody DriversDTO driversDTO){
		DriversDTO dto = driverFacade.save(driversDTO);
		return new ResponseEntity<DriversDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DriversDTO>returnsDriverDTOByGivenId(@PathVariable Integer id){
		DriversDTO dto = driverFacade.findDriversById(id);
		return new ResponseEntity<DriversDTO>(dto, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<DriversDTO>updateDrivers(@Valid @RequestBody DriversDTO driversDTO){
		DriversDTO dto = driverFacade.save(driversDTO);
		return new ResponseEntity<DriversDTO>(dto, HttpStatus.OK);
	}

		
	@PostMapping("/addVehicle/drivers/{idDriver}/vehicles/{idVehicle}")
	public ResponseEntity<DriversDTO> addVehicleToDriver(@PathVariable Integer idDriver,

			@PathVariable Integer idVehicle) {
		DriversDTO dto = driverFacade.addVehicleToDriver(idDriver, idVehicle);
		return new ResponseEntity<DriversDTO>(dto, HttpStatus.OK);
	}
	 
	@PostMapping("insert/vehicle/{idVehicle}/maintenaceCategory/{idMaitenanceCategory}/drivers/{idDriver}")
	public ResponseEntity<VehicleDamageReportDTO>insertNewVehicleDamageReport(@Valid @RequestBody VehicleDamageReportDTO vehicleDamageReportDTO,
			@PathVariable Integer idVehicle, @PathVariable Integer idMaitenanceCategory, @PathVariable Integer idDriver ){
		VehicleDamageReportDTO dto = vehicleDamageReportFacade.save(vehicleDamageReportDTO, idVehicle, idMaitenanceCategory, idDriver);
		return new ResponseEntity<VehicleDamageReportDTO>(dto, HttpStatus.OK);
	}
	

}
