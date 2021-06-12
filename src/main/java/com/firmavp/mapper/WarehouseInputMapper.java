package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.WarehouseInputDTO;
import com.firmavp.entity.WarehouseInput;

public interface WarehouseInputMapper {
	
	WarehouseInputDTO toWarehouseInputDTO(WarehouseInput warehouseInput);
	WarehouseInput toWarehouseInput(WarehouseInputDTO warehouseInputDTO);
	List<WarehouseInputDTO>toWarehouseInputDTOs(List<WarehouseInput>listWarehouseInputs);
	List<WarehouseInput>toWarehouseInputs(List<WarehouseInputDTO>warehouseInputDTOs);
	

}
