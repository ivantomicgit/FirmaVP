package com.firmavp.fasada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.firmavp.dto.VehicleRegistrationDTO;
import com.firmavp.entity.Address;
import com.firmavp.entity.Company;
import com.firmavp.entity.Vehicle;
import com.firmavp.entity.VehicleCategory;
import com.firmavp.entity.VehicleRegistration;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.VehicleCategoryMapper;
import com.firmavp.mapper.VehicleMapper;
import com.firmavp.mapper.VehicleRegistrationMapper;
import com.firmavp.service.AddressService;
import com.firmavp.service.VehicleCategoryService;
import com.firmavp.service.VehicleRegistrationService;
import com.firmavp.service.VehicleService;

@Component
public class VehicleRegistrationFacadeImpl implements VehicleRegistrationFacade {

	private final VehicleRegistrationService registrationService;
	private final VehicleService vehicleService;
	private final VehicleRegistrationMapper vehicleRegistrationMapper;
	private final VehicleMapper vehicleMapper;

	@Autowired
	public VehicleRegistrationFacadeImpl(VehicleRegistrationService registrationService, VehicleService vehicleService,
			VehicleRegistrationMapper vehicleRegistrationMapper, VehicleMapper vehicleMapper) {
		super();
		this.registrationService = registrationService;
		this.vehicleService = vehicleService;
		this.vehicleRegistrationMapper = vehicleRegistrationMapper;
		this.vehicleMapper = vehicleMapper;
	}

	public Vehicle getAndCheckVehicle(Integer idVehicle) {
		Vehicle vehicleFromDatabase = vehicleMapper.toVehicle(vehicleService.findVehicle(idVehicle));

		if (vehicleFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("ne vehicle for id " + idVehicle)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		return vehicleFromDatabase;
	}

	@Override
	public VehicleRegistrationDTO save(VehicleRegistrationDTO vehicleRegistrationDTO, Integer companyId,
			Integer vehicleIid) {

		Vehicle vehicle = getAndCheckVehicle(vehicleIid);
		VehicleRegistration vehicleRegistration = vehicleRegistrationMapper
				.toVehicleRegistration(vehicleRegistrationDTO);

		try {
			vehicleRegistration.setVehicle(vehicle);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("data not saved")
					.withError_code("NOT_SAVED").withStatus(HttpStatus.BAD_REQUEST).build();
		}

		VehicleRegistration vr = registrationService.save(vehicleRegistration);

		return vehicleRegistrationMapper.toVehicleregistrationDTO(vr);
	}

	@Override
	public VehicleRegistrationDTO update(VehicleRegistrationDTO registrationDTO, Integer companyId, Integer vehicleIid) {

		Vehicle vehicle = getAndCheckVehicle(vehicleIid);
		VehicleRegistration vehicleRegistration = vehicleRegistrationMapper.toVehicleRegistration(registrationDTO);

		try {
			vehicleRegistration.setVehicle(vehicle);
			registrationService.update(vehicleRegistration);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("data not saved")
					.withError_code("NOT_SAVED").withStatus(HttpStatus.BAD_REQUEST).build();

		}
		return vehicleRegistrationMapper.toVehicleregistrationDTO(vehicleRegistration);
	}

}
