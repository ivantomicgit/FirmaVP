package com.firmavp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.VehicleRegistrationDTO;
import com.firmavp.entity.VehicleRegistration;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.VehicleRegistrationMapper;
import com.firmavp.repository.VehicleRegistrationRepository;
import com.firmavp.service.VehicleRegistrationService;

@Service
public class VehicleRegistrationServiceImpl implements VehicleRegistrationService {

	private final VehicleRegistrationRepository registrationRepository;
	private final VehicleRegistrationMapper registrationMapper;

	@Autowired
	public VehicleRegistrationServiceImpl(VehicleRegistrationRepository registrationRepository,
			VehicleRegistrationMapper registrationMapper) {
		super();
		this.registrationRepository = registrationRepository;
		this.registrationMapper = registrationMapper;
	}

	@Override
	@Transactional
	public VehicleRegistration save(VehicleRegistration vehicleRegistration) {
		// TODO Auto-generated method stub
		return registrationRepository.save(vehicleRegistration);
	}

	@Override
	@Transactional(readOnly = true)
	public VehicleRegistrationDTO findVehiclevehicleRegistration(Integer id) {
		VehicleRegistration vrFromDatabase = registrationRepository.findVehicleRegistrationById(id);
		if (vrFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no registration in database fod id " + id)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		return registrationMapper.toVehicleregistrationDTO(vrFromDatabase);
	}

	@Override
	@Transactional
	public VehicleRegistration update(VehicleRegistration vehicleRegistration) {
		return registrationRepository.save(vehicleRegistration);

	}

	@Override
	@Transactional
	public void delete(Integer id) {
		VehicleRegistration vrFromDatabase = registrationRepository.findVehicleRegistrationById(id);
		if (vrFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no registration in database fod id " + id)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		registrationRepository.delete(vrFromDatabase);

	}

}
