package com.firmavp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.VehicleDescriptionOfMaintenanceDTO;
import com.firmavp.entity.Vehicle;
import com.firmavp.entity.VehicleDamageReport;
import com.firmavp.entity.VehicleDescriptionOfMaintenance;
import com.firmavp.entity.VehicleMaintenanceCategory;
import com.firmavp.enums.DamageRepaired;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.VehicleDescriptionOfMaintenanceMapper;
import com.firmavp.repository.VehicleDamageReportRepository;
import com.firmavp.repository.VehicleDescriptionOfMaintenanceRepository;
import com.firmavp.repository.VehicleMaintenanceCategoryRepository;
import com.firmavp.repository.VehicleRepository;
import com.firmavp.service.VehicleDamageReportService;
import com.firmavp.service.VehicleDescriptionOfMaintenanceService;

@Service
public class VehicleDescriptionOfMaintenanceServiceImpl implements VehicleDescriptionOfMaintenanceService {

	private final VehicleDescriptionOfMaintenanceRepository descriptionOfMaintenanceRepository;
	private final VehicleRepository vehicleRepository;
	private final VehicleMaintenanceCategoryRepository vehicleMaintenanceCategoryRepository;
	private final VehicleDescriptionOfMaintenanceMapper descriptionOfMaintenanceMapper;
	private final VehicleDamageReportRepository damageReportRepository;
	private final VehicleDamageReportService damageReportService;

	@Autowired
	public VehicleDescriptionOfMaintenanceServiceImpl(
			VehicleDescriptionOfMaintenanceRepository descriptionOfMaintenanceRepository, VehicleDescriptionOfMaintenanceMapper descriptionOfMaintenanceMapper, 
			VehicleMaintenanceCategoryRepository vehicleMaintenanceCategoryRepository, VehicleRepository vehicleRepository,
			VehicleDamageReportRepository damageReportRepository, VehicleDamageReportService damageReportService) {
		super();
		this.descriptionOfMaintenanceRepository = descriptionOfMaintenanceRepository;
		this.descriptionOfMaintenanceMapper = descriptionOfMaintenanceMapper;
		this.vehicleMaintenanceCategoryRepository = vehicleMaintenanceCategoryRepository;
		this.vehicleRepository = vehicleRepository;
		this.damageReportRepository = damageReportRepository;
		this.damageReportService = damageReportService;
	}

	@Override
	@Transactional
	public VehicleDescriptionOfMaintenanceDTO repair(VehicleDescriptionOfMaintenanceDTO descriptionOfMaintenanceDTO,
			Integer idVehicle, Integer idMaintenanceCategory, Integer idDamageReport) {
		VehicleMaintenanceCategory categoryFromDatabase = vehicleMaintenanceCategoryRepository
				.findVehicleMaintenanceCategoryById(idMaintenanceCategory);
		if (categoryFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no category in database fod id " + idMaintenanceCategory)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		Vehicle vehicleFromDatabase = vehicleRepository.findVehicleById(idVehicle);
		if (vehicleFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no vehicle in database fod d " + idVehicle)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		
		VehicleDescriptionOfMaintenance descriptionOfMaintenance = descriptionOfMaintenanceMapper.toDescriptionOfMaintenance(descriptionOfMaintenanceDTO);
		descriptionOfMaintenance.setMaintenance_category(categoryFromDatabase);
		descriptionOfMaintenance.setVehicle(vehicleFromDatabase);
		
		VehicleDamageReport damageReport = damageReportRepository.findVehicleDamageReportById(idDamageReport);
		damageReport.setDamageRepaired(DamageRepaired.YES);
		damageReportRepository.save(damageReport);
		
		
		return descriptionOfMaintenanceMapper.toDescriptionOfMaintenanceDTO(descriptionOfMaintenanceRepository.save(descriptionOfMaintenance));
	}

}
