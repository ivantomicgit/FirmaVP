package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.WarehouseDTO;

import com.firmavp.entity.Warehouse;


public interface WarehouseMapper {
	
	WarehouseDTO toWarehouseDTO (Warehouse warehouse);
	Warehouse toWarehouse(WarehouseDTO warehouseDTO);
	List<WarehouseDTO>toWarehouseDTOs(List<Warehouse>listWarehouse);
	List<Warehouse>toWarehouses(List<WarehouseDTO>warehouseDTOs);
//	List<WarehouseDTO>toWarehouseInputDTOs(List<Warehouse>listWarehouse);
//	List<WarehouseDTO>toWarehouseOutputDTOs(List<Warehouse>listWarehouse);

}
