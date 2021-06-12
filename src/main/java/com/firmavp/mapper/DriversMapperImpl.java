package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.DriversDTO;
import com.firmavp.dto.VehicleDTO;
import com.firmavp.entity.Drivers;
import com.firmavp.entity.Vehicle;

@Component
public class DriversMapperImpl implements DriversMapper {
	private final VehicleMapper vehicleMapper;
	private final StaffMapper staffMapper;
	

	@Autowired
	public DriversMapperImpl(VehicleMapper vehicleMapper, StaffMapper staffMapper) {
		super();
		this.vehicleMapper = vehicleMapper;
		this.staffMapper = staffMapper;
	}

	@Override
	public List<DriversDTO> toDriversDTOs(List<Drivers> list) {
		List<DriversDTO> listDriversDTO = new ArrayList<DriversDTO>();
		for (Drivers drivers : list) {
			DriversDTO driversDTO = new DriversDTO();
			driversDTO.setId(drivers.getId());
			driversDTO.setStaffDTO(staffMapper.toStaffDTO(drivers.getStaff()));
			driversDTO.setDriverLicenceNumber(drivers.getDriverLicenceNumber());
			driversDTO.setLicenceCategories(drivers.getLicenceCategories());
			driversDTO.setNationalIdentificationNumber(drivers.getNationalIdentificationNumber());
//			driversDTO.setVehiclesDTO(new HashSet<VehicleDTO>());
//			for (Vehicle vehicle : drivers.getVehicles()) {
//				driversDTO.getVehiclesDTO().add(vehicleMapper.toVehicleDTO(vehicle));
//			}
			listDriversDTO.add(driversDTO);
		}
		return listDriversDTO;
	}

	@Override
	public Drivers toDrivers(DriversDTO driversDTO) {
		Drivers drivers = new Drivers();
		drivers.setId(driversDTO.getId());
		drivers.setStaff(staffMapper.toStaff(driversDTO.getStaffDTO()));
		drivers.setDriverLicenceNumber(driversDTO.getDriverLicenceNumber());
		drivers.setLicenceCategories(driversDTO.getLicenceCategories());
		drivers.setNationalIdentificationNumber(driversDTO.getNationalIdentificationNumber());
//		drivers.setVehicles(new HashSet<Vehicle>());
//		for (VehicleDTO vehicleDTO : driversDTO.getVehiclesDTO()) {
//			drivers.getVehicles().add(vehicleMapper.toVehicle(vehicleDTO));
//		}
		return drivers;
	}

	@Override
	public DriversDTO toDriversDTO(Drivers drivers) {
		DriversDTO driversDTO = new DriversDTO();
		driversDTO.setId(drivers.getId());
		driversDTO.setStaffDTO(staffMapper.toStaffDTO(drivers.getStaff()));
		driversDTO.setDriverLicenceNumber(drivers.getDriverLicenceNumber());
		driversDTO.setLicenceCategories(drivers.getLicenceCategories());
		driversDTO.setNationalIdentificationNumber(drivers.getNationalIdentificationNumber());
//		driversDTO.setVehiclesDTO(new HashSet<VehicleDTO>());
//		for (Vehicle vehicle : drivers.getVehicles()) {
//			driversDTO.getVehiclesDTO().add(vehicleMapper.toVehicleDTO(vehicle));
//		}
		return driversDTO;
	}

	@Override
	public List<Drivers> toDrivers(List<DriversDTO> list) {
		List<Drivers> listDrivers = new ArrayList<Drivers>();
		for (DriversDTO driversDTO : list) {
			Drivers drivers = new Drivers();
			drivers.setId(driversDTO.getId());
			drivers.setStaff(staffMapper.toStaff(driversDTO.getStaffDTO()));
			drivers.setDriverLicenceNumber(driversDTO.getDriverLicenceNumber());
			drivers.setLicenceCategories(driversDTO.getLicenceCategories());
			drivers.setNationalIdentificationNumber(driversDTO.getNationalIdentificationNumber());
//			drivers.setVehicles(new HashSet<Vehicle>());
//			for (VehicleDTO vehicleDTO : driversDTO.getVehiclesDTO()) {
//				drivers.getVehicles().add(vehicleMapper.toVehicle(vehicleDTO));
//			}
			listDrivers.add(drivers);
		}
		return listDrivers;
	}

}
