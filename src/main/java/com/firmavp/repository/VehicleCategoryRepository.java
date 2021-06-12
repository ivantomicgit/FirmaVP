package com.firmavp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.VehicleCategory;

@Repository
public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Integer>{

	VehicleCategory findVehicleCategoryById(Integer id);

}
