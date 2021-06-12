package com.firmavp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.WarehouseInput;
@Repository
public interface WarehouseInputRepository  extends JpaRepository<WarehouseInput, Integer>{

}
