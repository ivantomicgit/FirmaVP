package com.firmavp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.MileageReport;
import com.firmavp.entity.Vehicle;
@Repository
public interface MileageReportRepository extends JpaRepository<MileageReport, Integer> {

	MileageReport findMileageReportById(Integer id);

	List<MileageReport> findMileageReportByVehicle(Vehicle vehicle);

	@Query(nativeQuery = true, value = "select * from mileage_report as m where  m.vehicle_id=? AND m.date_of_entry BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59') ORDER BY m.number_of_kilometers DESC")
	List<MileageReport> allKilometersMileageForDriverAndVehicle(Integer vehicle_id);

	@Query(nativeQuery = true, value = "select * from mileage_report as m where m.vehicle_id=? AND m.date_of_entry BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59') ORDER BY m.number_of_hours DESC")
	List<MileageReport> allHoursMileageForDriverAndVehicle(Integer vehicle_id);

}
