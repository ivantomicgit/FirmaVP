package com.firmavp.fasada;

import com.firmavp.dto.VehicleRegistrationDTO;
import com.firmavp.entity.VehicleRegistration;

public interface VehicleRegistrationFacade {

	VehicleRegistrationDTO save(VehicleRegistrationDTO vehicleRegistrationDTO, Integer companyId, Integer vehicleIid);

	VehicleRegistrationDTO update(VehicleRegistrationDTO registrationDTO, Integer companyId, Integer vehicleIid);

	

	
	

}
