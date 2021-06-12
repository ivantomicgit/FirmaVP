package com.firmavp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.VehicleDescriptionOfMaintenance;

@Repository
public interface VehicleDescriptionOfMaintenanceRepository extends JpaRepository<VehicleDescriptionOfMaintenance, Integer>{

}
