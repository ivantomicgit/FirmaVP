package com.firmavp.fasada;

import java.util.List;

import com.firmavp.dto.WarehouseOutputDTO;


public interface WarehouseOutputFacade {
	List<WarehouseOutputDTO> save(List<WarehouseOutputDTO> warehouseOutputDTO,Integer idWarehouse);
	void deleteById(Integer id);
}
