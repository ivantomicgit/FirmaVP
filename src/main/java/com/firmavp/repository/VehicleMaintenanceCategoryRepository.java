package com.firmavp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.VehicleMaintenanceCategory;

@Repository
public interface VehicleMaintenanceCategoryRepository extends JpaRepository<VehicleMaintenanceCategory, Integer>{

	VehicleMaintenanceCategory findVehicleMaintenanceCategoryById(Integer id);

}
