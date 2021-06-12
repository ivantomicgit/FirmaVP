package com.firmavp.fasada;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.firmavp.dto.AverageFuelConsumptionDTO;
import com.firmavp.dto.RealFuelConsumptionDTO;
import com.firmavp.dto.VehicleDTO;
import com.firmavp.entity.AverageFuelConsumption;
import com.firmavp.entity.Drivers;
import com.firmavp.entity.Vehicle;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.AverageFuelConsumptionMapper;
import com.firmavp.mapper.VehicleMapper;
import com.firmavp.service.AverageFuelConsumptionService;
import com.firmavp.service.DriversService;
import com.firmavp.service.FuelPurchaseService;
import com.firmavp.service.MileageReportService;
import com.firmavp.service.VehicleService;


@Component
public class AverageFuelConsumptionFacadeImpl implements AverageFuelConsumptionFacade {
	private final AverageFuelConsumptionService averageFuelConsumptionService;
	private final AverageFuelConsumptionMapper averageFuelConsumptionMapper;
	private final VehicleService vehicleService;
	private final DriversService driversService;
	private final VehicleMapper vehicleMapper;
	private final FuelPurchaseService fuelPurchaseService;
	private final MileageReportService mileageReportService;

	@Autowired
	public AverageFuelConsumptionFacadeImpl(AverageFuelConsumptionService averageFuelConsumptionService,
			AverageFuelConsumptionMapper averageFuelConsumptionMapper, VehicleService vehicleService,
			DriversService driversService, VehicleMapper vehicleMapper, FuelPurchaseService fuelPurchaseService, MileageReportService mileageReportService) {
		super();
		this.averageFuelConsumptionService = averageFuelConsumptionService;
		this.averageFuelConsumptionMapper = averageFuelConsumptionMapper;
		this.vehicleService = vehicleService;
		this.driversService = driversService;
		this.vehicleMapper = vehicleMapper;
		this.fuelPurchaseService = fuelPurchaseService;
		this.mileageReportService = mileageReportService;
	}
	




	@Override
	public List<AverageFuelConsumptionDTO> findAll() {
		List<AverageFuelConsumption> list = null;
		try {
			list = averageFuelConsumptionService.findAll();
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withMessage("").withError_code(HttpStatus.NOT_FOUND.name()).withDetail("No average fuel consumptions found.").build();
		}		
		List<AverageFuelConsumptionDTO> listaDTO = averageFuelConsumptionMapper.toAverageFuelConsumptionDTOs(list);		
		return listaDTO;
	}









	@Override
	public AverageFuelConsumptionDTO save(@Valid AverageFuelConsumptionDTO averageFuelConsumptionDTO,
			Integer idVehicle) {
		VehicleDTO vehicleDTO = null;
		try {
			vehicleDTO = vehicleService.findVehicle(idVehicle);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withError_code(HttpStatus.NOT_FOUND.name()).withMessage("").withDetail("Vehicle with id" + idVehicle + "not found.").build();
		}
		averageFuelConsumptionDTO.setVehicleDTO(vehicleDTO);
		AverageFuelConsumption averageFuelConsumption = averageFuelConsumptionMapper.toAverageFuelConsumption(averageFuelConsumptionDTO);
		averageFuelConsumption = averageFuelConsumptionService.save(averageFuelConsumption);
		averageFuelConsumptionDTO  = averageFuelConsumptionMapper.toAverageFuelConsumptionDTO(averageFuelConsumption);
		return averageFuelConsumptionDTO;
	}



	@Override
	public AverageFuelConsumptionDTO findAverageFuelConsumptionById(Integer id) {
		AverageFuelConsumption averageFuelConsumption = null;
		try {
			averageFuelConsumption = averageFuelConsumptionService.findAverageFuelConsumptionById(id);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withError_code(HttpStatus.NOT_FOUND.name()).withMessage("").withDetail("Average fuel consumption with id" + id + "not found.").build();
		}
		AverageFuelConsumptionDTO averageFuelConsumptionDTO = averageFuelConsumptionMapper.toAverageFuelConsumptionDTO(averageFuelConsumption);
		return averageFuelConsumptionDTO;
	}




	@Override
	public RealFuelConsumptionDTO realFuelConsumption(Integer idDriver, Integer idVehicle) {
		Drivers driver = null;
		try {
			driver = driversService.findDriversById(idDriver);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withError_code(HttpStatus.NOT_FOUND.name()).withMessage("").withDetail("Driver with id" + idDriver + "not found.").build();
		}
		
		
		int mileageType = -1;
		RealFuelConsumptionDTO realFuelConsumptionDTO = new RealFuelConsumptionDTO();
		if (returnAverageFuelConsumptionByVehicle(idVehicle).getConsumptionPer100km() == null) {
			realFuelConsumptionDTO.setAverageFuelConsumption(returnAverageFuelConsumptionByVehicle(idVehicle).getConsumptionPerHour());
			mileageType = 0;
		} else {

			realFuelConsumptionDTO.setAverageFuelConsumption(returnAverageFuelConsumptionByVehicle(idVehicle).getConsumptionPer100km());
			mileageType = 1;
		}
		
		
		Double fuel = fuelPurchaseService.allFuelPurchasedByDriverAndVehicle(idDriver, idVehicle);
		Double mileage = mileageReportService.allMileageForDriverAndVehicle(idDriver, idVehicle, mileageType);
		Double realFuelConsumtionValue = null;
		if (mileageType == 0) {
			realFuelConsumtionValue = fuel/mileage;
		} else {

			realFuelConsumtionValue = fuel/(mileage/100);
		}
		
		realFuelConsumptionDTO.setRealFuelConsumtion(realFuelConsumtionValue);
		
		return realFuelConsumptionDTO;
	}





	@Override
	public AverageFuelConsumptionDTO findAverageFuelConsumptionByVehicle(Integer idVehicle) {
		return returnAverageFuelConsumptionByVehicle(idVehicle);
	}
	
	
	private AverageFuelConsumptionDTO returnAverageFuelConsumptionByVehicle(Integer idVehicle) {
		VehicleDTO vehicleDTO = null;
		try {
			vehicleDTO = vehicleService.findVehicle(idVehicle);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withError_code(HttpStatus.NOT_FOUND.name()).withMessage("").withDetail("Vehicle with id" + idVehicle + "not found.").build();
		}
		Vehicle vehicle = vehicleMapper.toVehicle(vehicleDTO);
		AverageFuelConsumption averageFuelConsumption = averageFuelConsumptionService.findAverageFuelConsumptionByVehicle(vehicle);
		return averageFuelConsumptionMapper.toAverageFuelConsumptionDTO(averageFuelConsumption);
	}



	

}



	