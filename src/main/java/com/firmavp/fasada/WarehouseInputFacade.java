package com.firmavp.fasada;

import java.util.List;

import com.firmavp.dto.WarehouseInputDTO;

public interface WarehouseInputFacade {

	
	List<WarehouseInputDTO> save(List<WarehouseInputDTO> warehouseInputDTO,Integer idWarehouse);
	void deleteById(Integer id);
}
