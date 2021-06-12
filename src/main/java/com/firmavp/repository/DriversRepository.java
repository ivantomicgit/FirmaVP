package com.firmavp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.Drivers;
@Repository
public interface DriversRepository extends JpaRepository<Drivers, Integer> {

	Drivers findDriversById(Integer id);

}
