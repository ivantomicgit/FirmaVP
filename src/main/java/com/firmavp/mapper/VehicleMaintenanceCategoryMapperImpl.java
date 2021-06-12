package com.firmavp.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.VehicleMaintenanceCategoryDTO;
import com.firmavp.entity.VehicleMaintenanceCategory;
@Component
public class VehicleMaintenanceCategoryMapperImpl implements VehicleMaintenanceCategoryMapper {

	private final VehicleDescriptionOfMaintenanceMapper vehicleDescriptionOfMaintenanceMapper;
	
	@Autowired
	public VehicleMaintenanceCategoryMapperImpl(
			VehicleDescriptionOfMaintenanceMapper vehicleDescriptionOfMaintenanceMapper) {
		super();
		this.vehicleDescriptionOfMaintenanceMapper = vehicleDescriptionOfMaintenanceMapper;
	}

	@Override
	public VehicleMaintenanceCategory toVehicleMaintenanceCategory(
			VehicleMaintenanceCategoryDTO vmcDTO) {
		VehicleMaintenanceCategory vmc = new VehicleMaintenanceCategory();
		vmc.setId(vmcDTO.getId());
		vmc.setCategoryName(vmcDTO.getCategoryName());
		vmc.setListVehicleMaintenanceDescriptions(vehicleDescriptionOfMaintenanceMapper.toListDescriptionOfMaintenance(vmcDTO.getListVehicleMaintenanceDescriptions()));
		return vmc;
	}

	@Override
	public VehicleMaintenanceCategoryDTO toVehicleMaintenanceCategoryDTO(VehicleMaintenanceCategory vmc) {
		VehicleMaintenanceCategoryDTO vmcDTO = new VehicleMaintenanceCategoryDTO();
		vmcDTO.setId(vmc.getId());
		vmcDTO.setCategoryName(vmc.getCategoryName());
		vmcDTO.setListVehicleMaintenanceDescriptions(vehicleDescriptionOfMaintenanceMapper.toListDescriptionOfMaintenanceDTO(vmc.getListVehicleMaintenanceDescriptions()));
		return vmcDTO;
	}

}
