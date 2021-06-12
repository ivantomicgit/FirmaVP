package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.VehicleDamageReportDTO;
import com.firmavp.entity.VehicleDamageReport;
@Component
public class VehicleDamageReportMapperImpl implements VehicleDamageReportMapper {

	private final VehicleMaintenanceCategoryMapper categoryMapper;
	private final VehicleMapper vehicleMapper;

	@Autowired
	public VehicleDamageReportMapperImpl(VehicleMaintenanceCategoryMapper categoryMapper, VehicleMapper vehicleMapper) {
		super();
		this.categoryMapper = categoryMapper;
		this.vehicleMapper = vehicleMapper;
	}

	@Override
	public VehicleDamageReport toVehicleDamageReport(@Valid VehicleDamageReportDTO vehicleDamageReportDTO) {
		VehicleDamageReport vehicleDamageReport = new VehicleDamageReport();
		vehicleDamageReport.setId(vehicleDamageReportDTO.getId());
		vehicleDamageReport.setDescription(vehicleDamageReportDTO.getDescription());
		//vehicleDamageReport.setVehicle(vehicleMapper.toVehicle(vehicleDamageReportDTO.getIdVehicle()));
		vehicleDamageReport.setTimeOfTheEvent(vehicleDamageReportDTO.getTimeOfTheEvent());
		vehicleDamageReport.setDamageRepaired(vehicleDamageReportDTO.getDamageRepaired());
		//vehicleDamageReport.setMaintenanceCategory(categoryMapper.toVehicleMaintenanceCategory(vehicleDamageReportDTO.getMaintenanceCategory()));
		return vehicleDamageReport;
	}

	

	@Override
	public VehicleDamageReportDTO toVehicleDamageReportDTO(VehicleDamageReport vehicleDamageReport) {
		VehicleDamageReportDTO vehicleDamageReportDTO = new VehicleDamageReportDTO();
		vehicleDamageReportDTO.setId(vehicleDamageReport.getId());
		vehicleDamageReportDTO.setDescription(vehicleDamageReport.getDescription());
		//vehicleDamageReportDTO.setIdVehicle(vehicleMapper.toVehicleDTO(vehicleDamageReport.getVehicle()));
		vehicleDamageReportDTO.setTimeOfTheEvent(vehicleDamageReport.getTimeOfTheEvent());
		vehicleDamageReportDTO.setDamageRepaired(vehicleDamageReport.getDamageRepaired());
		//vehicleDamageReportDTO.setMaintenanceCategory(categoryMapper.toVehicleMaintenanceCategoryDTO(vehicleDamageReport.getMaintenanceCategory()));
		return vehicleDamageReportDTO;
	}

	@Override
	public List<VehicleDamageReportDTO> toVehicleDamageReportDTOs(List<VehicleDamageReport> list) {
		List<VehicleDamageReportDTO> listDTO = new ArrayList<VehicleDamageReportDTO>();
		for (VehicleDamageReport vehicleDamageReport : list) {
			VehicleDamageReportDTO vehicleDamageReportDTO = new VehicleDamageReportDTO();
			vehicleDamageReportDTO.setId(vehicleDamageReport.getId());
			vehicleDamageReportDTO.setDescription(vehicleDamageReport.getDescription());
			//vehicleDamageReportDTO.setIdVehicle(vehicleMapper.toVehicleDTO(vehicleDamageReport.getVehicle()));
			vehicleDamageReportDTO.setTimeOfTheEvent(vehicleDamageReport.getTimeOfTheEvent());
			vehicleDamageReportDTO.setDamageRepaired(vehicleDamageReport.getDamageRepaired());
			//vehicleDamageReportDTO.setMaintenanceCategory(categoryMapper.toVehicleMaintenanceCategoryDTO(vehicleDamageReport.getMaintenanceCategory()));

			listDTO.add(vehicleDamageReportDTO);
		}
				return listDTO;
	}

}
