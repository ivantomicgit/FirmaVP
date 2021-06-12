package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.VehicleDTO;
import com.firmavp.entity.Vehicle;

public interface VehicleMapper {

	Vehicle toVehicle(VehicleDTO vehicle);

	VehicleDTO toVehicleDTO(Vehicle vehicle);

	List<VehicleDTO> toListVehiclesDTO(List<Vehicle> listVehicles);

}
