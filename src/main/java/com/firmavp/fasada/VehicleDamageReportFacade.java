package com.firmavp.fasada;

import java.util.List;

import javax.validation.Valid;

import com.firmavp.dto.VehicleDamageReportDTO;

public interface VehicleDamageReportFacade {

	VehicleDamageReportDTO save(@Valid VehicleDamageReportDTO vehicleDamageReportDTO, Integer idVehicle, Integer idMaitenanceCategory, Integer idDriver);

	VehicleDamageReportDTO findVehicleDamageReportById(Integer id);

	List<VehicleDamageReportDTO> findVehicleDamageReportByVehicleId(Integer idVehicle);

	//List<VehicleDamageReportDTO> findVehicleDamageReportByVehicleId(Integer idVehicle);

}
