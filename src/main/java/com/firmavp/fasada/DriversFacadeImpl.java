package com.firmavp.fasada;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.firmavp.dto.DriversDTO;
import com.firmavp.dto.VehicleDTO;
import com.firmavp.entity.Drivers;
import com.firmavp.entity.Vehicle;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.DriversMapper;
import com.firmavp.mapper.VehicleMapper;
import com.firmavp.service.DriversService;
import com.firmavp.service.VehicleService;
@Component
public class DriversFacadeImpl implements DriversFacade {
	private final DriversService driversService;
	private final DriversMapper driversMapper;
	private final VehicleService vehicleService;
	private final VehicleMapper vehicleMapper;
	
	
	
	@Autowired
	public DriversFacadeImpl(DriversService driversService, DriversMapper driversMapper, VehicleService vehicleService,
			VehicleMapper vehicleMapper) {
		super();
		this.driversService = driversService;
		this.driversMapper = driversMapper;
		this.vehicleService = vehicleService;
		this.vehicleMapper = vehicleMapper;
	}



	@Override
	public List<DriversDTO> findAll() {
		List<Drivers> list = null;
		try {
			list = driversService.findAll();
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withMessage("").withError_code(HttpStatus.NOT_FOUND.name()).withDetail("No drivers found.").build();
		}		
		List<DriversDTO> listaDTO = driversMapper.toDriversDTOs(list);		
		return listaDTO;
	}



	




	@Override
	public DriversDTO save(@Valid DriversDTO driversDTO) {
		
		Drivers drivers = driversMapper.toDrivers(driversDTO);
		drivers = driversService.save(drivers);
		driversDTO  = driversMapper.toDriversDTO(drivers);
		return driversDTO;
	}



	@Override
	public DriversDTO findDriversById(Integer id) {
		Drivers drivers = returnDriverWithId(id);
		DriversDTO driversDTO = driversMapper.toDriversDTO(drivers);
		return driversDTO;
	}








	@Override
	public DriversDTO addVehicleToDriver(Integer idDriver, Integer idVehicle) {
		Drivers drivers = returnDriverWithId(idDriver);
		VehicleDTO vehicleDTO = null;
		try {
			vehicleDTO = vehicleService.findVehicle(idVehicle);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withError_code(HttpStatus.NOT_FOUND.name()).withMessage("").withDetail("Vehicle with id" + idVehicle + "not found.").build();
		}
		
		Vehicle vehicle = vehicleMapper.toVehicle(vehicleDTO);
		drivers = driversService.addVehicleToDriver(drivers, vehicle);
		DriversDTO driversDTO = driversMapper.toDriversDTO(drivers);
		return driversDTO;
	}
	
	
	private Drivers returnDriverWithId(Integer id) {
		Drivers drivers = null;
		try {
			drivers = driversService.findDriversById(id);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withError_code(HttpStatus.NOT_FOUND.name()).withMessage("").withDetail("Drivers with id " + id + " not found.").build();
		}
		return drivers;
	}



}
