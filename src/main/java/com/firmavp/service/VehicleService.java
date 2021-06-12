package com.firmavp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.firmavp.dto.VehicleDTO;
import com.firmavp.dto.VehicleDamageReportDTO;

public interface VehicleService {

	VehicleDTO save(VehicleDTO vehicleDTO, Integer idVehicleCategory, Integer idCompany);

	VehicleDTO findVehicle(Integer id);

	VehicleDTO update(VehicleDTO vehicleDTO, Integer idVehicleCategory, Integer idCompany);

	void delete(Integer id);

	List<VehicleDTO> findAll();

	List<VehicleDTO> findAllDamagedVehicles(Integer idCompany);

	List<VehicleDTO> findVehiclesForCompanyId(Integer idVehicle);

	VehicleDTO findAllDamagesForVehicle(Integer idCompany, Integer idVehicle);

	VehicleDamageReportDTO findDamageReport(Integer idCompany, Integer idVehicle, Integer idDamageReport);

	//VehicleDTO findVehicleforComapny(Integer idCompany, Integer idVehicle);

	//VehicleDamageReportDTO repair(VehicleDamageReportDTO vehicleDamageReportDTO, Integer idVehicle);

	

}
