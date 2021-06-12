package com.firmavp.mapper;

import java.util.List;

import javax.validation.Valid;

import com.firmavp.dto.VehicleDamageReportDTO;
import com.firmavp.entity.VehicleDamageReport;

public interface VehicleDamageReportMapper {

	VehicleDamageReport toVehicleDamageReport(@Valid VehicleDamageReportDTO vehicleDamageReportDTO);

	VehicleDamageReportDTO toVehicleDamageReportDTO(VehicleDamageReport vehicleDamageReport);

	List<VehicleDamageReportDTO> toVehicleDamageReportDTOs(List<VehicleDamageReport> list);

	

}
