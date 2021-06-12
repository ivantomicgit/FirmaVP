package com.firmavp.service;

import java.util.List;

import com.firmavp.entity.MileageReport;
import com.firmavp.entity.Vehicle;

public interface MileageReportService {

	MileageReport save(MileageReport mileageReport);

	MileageReport findMileageReportById(Integer id);

	List<MileageReport> findMileageReportByVehicle_Id(Vehicle vehicle);

	Double allMileageForDriverAndVehicle(Integer idDriver, Integer idVehicle, int mileageType);


}
