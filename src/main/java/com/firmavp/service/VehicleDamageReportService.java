package com.firmavp.service;

import java.util.List;

import com.firmavp.dto.VehicleDamageReportDTO;
import com.firmavp.entity.VehicleDamageReport;

public interface VehicleDamageReportService {

	VehicleDamageReport save(VehicleDamageReport vehicleDamageReport);

	VehicleDamageReport findVehicleDamageReportById(Integer id);

	List<VehicleDamageReport> findAll();

	List<VehicleDamageReport> findVehicleDamageReportByVehicleId(Integer idVehicle);

	//VehicleDamageReportDTO repair(VehicleDamageReportDTO vehicleDamageReportDTO, Integer idVehicle);

}
