package com.firmavp.service;

import java.util.List;

import com.firmavp.dto.WarehouseDTO;
import com.firmavp.entity.Warehouse;

public interface WarehouseService {

	WarehouseDTO save(Warehouse warehouse);

	void deleteById(Integer id);

	List<Warehouse> findAll();

	WarehouseDTO updateWarehouse(Integer idAdress, Integer idCompany, WarehouseDTO warehouseDTO);

	List<Warehouse> findWarehouseByNameWarehouse(String name);

	Warehouse findWarehouseById(Integer idWarehouse);

	void deleteAll(List<WarehouseDTO> list);

}
