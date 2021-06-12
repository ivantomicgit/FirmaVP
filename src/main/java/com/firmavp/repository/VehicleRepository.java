package com.firmavp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

	Vehicle findVehicleById(Integer id);

	
}
