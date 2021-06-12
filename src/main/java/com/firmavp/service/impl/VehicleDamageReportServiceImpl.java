package com.firmavp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.VehicleDamageReportDTO;
import com.firmavp.entity.Vehicle;
import com.firmavp.entity.VehicleDamageReport;
import com.firmavp.entity.VehicleDescriptionOfMaintenance;
import com.firmavp.repository.VehicleDamageReportRepository;
import com.firmavp.repository.VehicleRepository;
import com.firmavp.service.VehicleDamageReportService;
import com.firmavp.service.VehicleService;
@Service
public class VehicleDamageReportServiceImpl implements VehicleDamageReportService {
	private final VehicleDamageReportRepository vehicleDamageReportRepository;
	private final VehicleRepository vehicleRepository;
	

	@Autowired
	public VehicleDamageReportServiceImpl(VehicleDamageReportRepository vehicleDamageReportRepository, VehicleRepository vehicleRepository) {
		super();
		this.vehicleDamageReportRepository = vehicleDamageReportRepository;
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	@Transactional
	public VehicleDamageReport save(VehicleDamageReport vehicleDamageReport) {
		
		return vehicleDamageReportRepository.save(vehicleDamageReport);
	}

	@Override
	@Transactional(readOnly = true)
	public VehicleDamageReport findVehicleDamageReportById(Integer id) {
		
		return vehicleDamageReportRepository.findVehicleDamageReportById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<VehicleDamageReport> findAll() {
		List<VehicleDamageReport> list = vehicleDamageReportRepository.findAll();
		return list;
		
	}

	@Override
	public List<VehicleDamageReport> findVehicleDamageReportByVehicleId(Integer idVehicle) {
		// TODO Auto-generated method stub
		return findVehicleDamageReportByVehicleId(idVehicle);
	}

//	@Override
//	public VehicleDamageReportDTO repair(VehicleDamageReportDTO vehicleDamageReportDTO, Integer idVehicle) {
//		VehicleDescriptionOfMaintenance descriptionOfMaintenance = new VehicleDescriptionOfMaintenance();
//		Vehicle vehicle = vehicleRepository.findVehicleById(idVehicle);
//		descriptionOfMaintenance.setVehicle(vehicle);
//		descriptionOfMaintenance.setDescription(vehicleDamageReportDTO.getDescription());
//		//  sve ovo sledece a i pre toga u descriptionOfMaintenance service koji treba da se napravi + kontroler
//		// verovatno u @Parhvarible ide i vehicleCategory
//		//dodas string kvar otklonjen
//		//save descriptionOfMaintenance
//		// setujesx enum u VehicleDamageReportDTO na suprutno to jes da nije damaged;
//		
//		return null;
//	}

}
