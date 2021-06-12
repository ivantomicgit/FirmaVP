package com.firmavp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.entity.MileageReport;
import com.firmavp.entity.Vehicle;
import com.firmavp.repository.MileageReportRepository;
import com.firmavp.service.MileageReportService;

@Service
public class MileageReportServiceImpl implements MileageReportService {
	private final MileageReportRepository mileageReportRepository;
	
	

	@Autowired
	public MileageReportServiceImpl(MileageReportRepository mileageReportRepository) {
		super();
		this.mileageReportRepository = mileageReportRepository;
	}



	@Override
	@Transactional
	public MileageReport save(MileageReport mileageReport) {

		return mileageReportRepository.save(mileageReport);
	}



	@Override
	@Transactional(readOnly = true)
	public MileageReport findMileageReportById(Integer id) {
		
		return mileageReportRepository.findMileageReportById(id);
	}



	@Override
	@Transactional(readOnly = true)
	public List<MileageReport> findMileageReportByVehicle_Id(Vehicle vehicle) {
		
		return mileageReportRepository.findMileageReportByVehicle(vehicle);
	}



	@Override
	@Transactional
	public Double allMileageForDriverAndVehicle(Integer idDriver, Integer idVehicle, int mileageType) {
		List<MileageReport> mileageReports = new ArrayList<MileageReport>();
		double mileage = 0;
		Boolean IsDriver = false; //remembers if the last driver found is our driver
		if (mileageType == 1) {
			mileageReports = mileageReportRepository.allKilometersMileageForDriverAndVehicle(idVehicle);
			for (int i = 0; i < mileageReports.size(); i++) {
				if (mileageReports.get(i).getDrivers().getId() == idDriver && IsDriver == false) {
					IsDriver = true;
				} else if (mileageReports.get(i).getDrivers().getId() == idDriver && IsDriver == true) {
					mileage += mileageReports.get(i-1).getNumberOfKilometers() - mileageReports.get(i).getNumberOfKilometers();
				} else if (mileageReports.get(i).getDrivers().getId() != idDriver && IsDriver == true) {
					mileage += mileageReports.get(i-1).getNumberOfKilometers() - mileageReports.get(i).getNumberOfKilometers();
					IsDriver = false;
				}
			}	
		} else {
			mileageReports = mileageReportRepository.allHoursMileageForDriverAndVehicle(idVehicle);
			for (int i = 0; i < mileageReports.size(); i++) {
				if (mileageReports.get(i).getDrivers().getId() == idDriver && IsDriver == false) {
					IsDriver = true;
				} else if (mileageReports.get(i).getDrivers().getId() == idDriver && IsDriver == true) {
					mileage += mileageReports.get(i-1).getNumberOfHours() - mileageReports.get(i).getNumberOfHours();
				} else if (mileageReports.get(i).getDrivers().getId() != idDriver && IsDriver == true) {
					mileage += mileageReports.get(i-1).getNumberOfHours() - mileageReports.get(i).getNumberOfHours();
					IsDriver = false;
				}
			}	
		}
		
		return mileage;
	}

}
