package com.firmavp.service;

import com.firmavp.dto.VehicleRegistrationDTO;
import com.firmavp.entity.VehicleRegistration;

public interface VehicleRegistrationService {

	VehicleRegistration save(VehicleRegistration vehicleRegistration);

	VehicleRegistrationDTO findVehiclevehicleRegistration(Integer id);

	VehicleRegistration update(VehicleRegistration vehicleRegistration);

	void delete(Integer id);

}
