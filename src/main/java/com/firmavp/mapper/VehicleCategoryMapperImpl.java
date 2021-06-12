package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.VehicleCategoryDTO;
import com.firmavp.dto.VehicleRegistrationDTO;
import com.firmavp.entity.VehicleCategory;
import com.firmavp.entity.VehicleRegistration;

@Component
public class VehicleCategoryMapperImpl implements VehicleCategoryMapper {
    
	
	@Override
	public VehicleCategory toVehicleCategory(VehicleCategoryDTO vehicleCategoryDTO) {
		VehicleCategory category = new VehicleCategory();
		category.setId(vehicleCategoryDTO.getId());
		category.setCategoryName(vehicleCategoryDTO.getCategoryName());
		
		return category;
	}

	@Override
	public VehicleCategoryDTO toVehicleCategoryDTO(VehicleCategory vehicleCategory_id) {
		VehicleCategoryDTO categoryDTO = new VehicleCategoryDTO();
		categoryDTO.setId(vehicleCategory_id.getId());
		categoryDTO.setCategoryName(vehicleCategory_id.getCategoryName());
		
		return categoryDTO;
	}

	@Override
	public List<VehicleCategoryDTO> toListVehicleCategoryDTO(List<VehicleCategory> findAll) {
		List<VehicleCategoryDTO> listCategoryDTO = new ArrayList<VehicleCategoryDTO>();
		for(VehicleCategory vc : findAll) {
			VehicleCategoryDTO vcDTO = new VehicleCategoryDTO();
			vcDTO.setId(vc.getId());
			vcDTO.setCategoryName(vc.getCategoryName());
		
			listCategoryDTO.add(vcDTO);
		}
		return listCategoryDTO;
	}

}
