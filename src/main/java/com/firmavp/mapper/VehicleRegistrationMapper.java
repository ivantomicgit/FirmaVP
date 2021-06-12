package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.VehicleRegistrationDTO;
import com.firmavp.entity.VehicleRegistration;

public interface VehicleRegistrationMapper {

	VehicleRegistration toVehicleRegistration(VehicleRegistrationDTO vehicleRegistrationDTO);

	VehicleRegistrationDTO toVehicleregistrationDTO(VehicleRegistration vehicleRegistration);

	List<VehicleRegistration> toListVehicleRegistrations(List<VehicleRegistrationDTO> lsitVehicleRegistrations);

	List<VehicleRegistrationDTO> toListVehicleRegistrationsDTO(List<VehicleRegistration> lsitVehicleRegistrations);

	
	
}
