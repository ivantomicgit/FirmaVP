package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.VehicleDTO;
import com.firmavp.entity.Vehicle;
@Component
public class VehicleMapperImpl implements VehicleMapper {
	@Autowired
	private VehicleDamageReportMapper damageReportMapper;

	@Override
	public Vehicle toVehicle(VehicleDTO vehicleDTO) {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(vehicleDTO.getId());
		vehicle.setVehicleName(vehicleDTO.getVehicleName());
		//vehicle.getLsitVehicleDamageReport(damageReportMapper.toVehicleDamageReport(vehicleDTO.getLsitVehicleDamageReport()));
		return vehicle;
	}

	@Override
	public VehicleDTO toVehicleDTO(Vehicle vehicle) {
		VehicleDTO vDTO = new VehicleDTO();
		vDTO.setId(vehicle.getId());
		vDTO.setVehicleName(vehicle.getVehicleName());
		vDTO.setLsitVehicleDamageReport(damageReportMapper.toVehicleDamageReportDTOs(vehicle.getLsitVehicleDamageReport()));
		return vDTO;
	}

	@Override
	public List<VehicleDTO> toListVehiclesDTO(List<Vehicle> listVehicles) {
		List<VehicleDTO> listVehiclesDTO = new ArrayList<VehicleDTO>();
		for(Vehicle v : listVehicles) {
			VehicleDTO vozilaDTO = new VehicleDTO();
			vozilaDTO.setId(v.getId());
			vozilaDTO.setVehicleName(v.getVehicleName());
		   vozilaDTO.setLsitVehicleDamageReport(damageReportMapper.toVehicleDamageReportDTOs(v.getLsitVehicleDamageReport()));
			listVehiclesDTO.add(vozilaDTO);
		}
		return listVehiclesDTO;
	}

}
