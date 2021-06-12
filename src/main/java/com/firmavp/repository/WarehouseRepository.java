package com.firmavp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.dto.WarehouseDTO;
import com.firmavp.entity.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

	List<Warehouse> findWarehouseByNameWarehouse(String name);

	Warehouse findWarehouseById(Integer idWarehouse);

}
