package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.WarehouseOutputDTO;
import com.firmavp.entity.WarehouseOutput;



public interface WarehouseOutputMapper {
	WarehouseOutputDTO toWarehouseOutputDTO (WarehouseOutput warehouseOutput);
	WarehouseOutput toWarehouseOutput(WarehouseOutputDTO warehouseOutputDTO);
	List<WarehouseOutputDTO>toWarehouseDTOs(List<WarehouseOutput>listWarehouseOutput);
	List<WarehouseOutput>toWarehouseOutputs(List<WarehouseOutputDTO>warehouseOutputDTOs);
}
