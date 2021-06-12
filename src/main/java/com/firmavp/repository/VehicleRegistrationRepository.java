package com.firmavp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.VehicleRegistration;

@Repository
public interface VehicleRegistrationRepository extends JpaRepository<VehicleRegistration, Integer>{

	VehicleRegistration findVehicleRegistrationById(Integer id);

}
