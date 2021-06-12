package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.VehicleCategoryDTO;
import com.firmavp.entity.VehicleCategory;

public interface VehicleCategoryMapper {

	VehicleCategory toVehicleCategory(VehicleCategoryDTO vehicleCategoryDTO);

	VehicleCategoryDTO toVehicleCategoryDTO(VehicleCategory vehicleCategory_id);

	List<VehicleCategoryDTO> toListVehicleCategoryDTO(List<VehicleCategory> findAll);

}
