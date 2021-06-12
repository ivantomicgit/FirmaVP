package com.firmavp.fasada;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.VehicleDamageReportDTO;
import com.firmavp.entity.Drivers;
import com.firmavp.entity.Vehicle;
import com.firmavp.entity.VehicleDamageReport;
import com.firmavp.entity.VehicleMaintenanceCategory;
import com.firmavp.enums.DamageRepaired;
import com.firmavp.mapper.DriversMapper;
import com.firmavp.mapper.VehicleDamageReportMapper;
import com.firmavp.mapper.VehicleMaintenanceCategoryMapper;
import com.firmavp.mapper.VehicleMapper;
import com.firmavp.service.DriversService;
import com.firmavp.service.VehicleDamageReportService;
import com.firmavp.service.VehicleMaintenanceCategoryService;
import com.firmavp.service.VehicleService;
@Component
public class VehicleDamageReportFacadeImpl implements VehicleDamageReportFacade {
	private final VehicleDamageReportService vehicleDamageReportService;
	private final VehicleDamageReportMapper vehicleDamageReportMapper;
	private final VehicleService vehicleService;
	private final VehicleMapper vehicleMapper;
	private final VehicleMaintenanceCategoryService maintenanceCategoryService;
	private final VehicleMaintenanceCategoryMapper maintenaceCategoryMapper;
	private final DriversService driversService;
	private final DriversMapper driversMapper;

	@Autowired
	public VehicleDamageReportFacadeImpl(VehicleDamageReportService vehicleDamageReportService,
			VehicleDamageReportMapper vehicleDamageReportMapper, VehicleService vehicleService, VehicleMapper vehicleMapper, VehicleMaintenanceCategoryService maintenanceCategoryService,
			VehicleMaintenanceCategoryMapper maintenaceCategoryMapper, DriversService driversService, DriversMapper driversMapper) {
		super();
		this.vehicleDamageReportService = vehicleDamageReportService;
		this.vehicleDamageReportMapper = vehicleDamageReportMapper;
		this.vehicleService = vehicleService;
		this.vehicleMapper = vehicleMapper;
		this.maintenanceCategoryService = maintenanceCategoryService;
		this.maintenaceCategoryMapper = maintenaceCategoryMapper;
		this.driversService = driversService;
		this.driversMapper = driversMapper;
	}

	@Override
	public VehicleDamageReportDTO save(@Valid VehicleDamageReportDTO vehicleDamageReportDTO, Integer idVehicle, Integer idMaitenanceCategory, Integer idDriver) {
		Vehicle vehicle = vehicleMapper.toVehicle(vehicleService.findVehicle(idVehicle));
		VehicleMaintenanceCategory maintenanceCategory =
				maintenaceCategoryMapper.toVehicleMaintenanceCategory((maintenanceCategoryService.findVehicleMaintenanceCategory(idMaitenanceCategory)));
		Drivers driver = driversService.findDriversById(idDriver);
		
		VehicleDamageReport vehicleDamageReport = vehicleDamageReportMapper.toVehicleDamageReport(vehicleDamageReportDTO);
		vehicleDamageReport.setVehicle(vehicle);
		vehicleDamageReport.setMaintenanceCategory(maintenanceCategory);
		vehicleDamageReport.setDrivers(driver);
		vehicleDamageReport.setDamageRepaired(DamageRepaired.NO);
		vehicleDamageReport = vehicleDamageReportService.save(vehicleDamageReport);
		return vehicleDamageReportMapper.toVehicleDamageReportDTO(vehicleDamageReport);
	}


	@Override
	public VehicleDamageReportDTO findVehicleDamageReportById(Integer id) {
		VehicleDamageReport vehicleDamageReport = vehicleDamageReportService.findVehicleDamageReportById(id);
		return vehicleDamageReportMapper.toVehicleDamageReportDTO(vehicleDamageReport);
	}


	@Override
	public List<VehicleDamageReportDTO> findVehicleDamageReportByVehicleId(Integer idVehicle) {
		List<VehicleDamageReport> list = vehicleDamageReportService.findVehicleDamageReportByVehicleId(idVehicle);
		return vehicleDamageReportMapper.toVehicleDamageReportDTOs(list);
	}


}
