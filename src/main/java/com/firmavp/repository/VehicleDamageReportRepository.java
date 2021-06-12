package com.firmavp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.VehicleDamageReport;
@Repository
public interface VehicleDamageReportRepository extends JpaRepository<VehicleDamageReport, Integer> {

	VehicleDamageReport findVehicleDamageReportById(Integer id);

	List<VehicleDamageReport> findVehicleDamageReportByVehicleId(Integer idVehicle);

}
