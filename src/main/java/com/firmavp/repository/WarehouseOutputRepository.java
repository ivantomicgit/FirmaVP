package com.firmavp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.WarehouseOutput;

@Repository
public interface WarehouseOutputRepository extends JpaRepository<WarehouseOutput, Integer> {

	List<WarehouseOutput> save(List<WarehouseOutput> warehouseOutput);


}
