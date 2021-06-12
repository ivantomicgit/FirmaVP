package com.firmavp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.VehicleMaintenanceCategoryDTO;
import com.firmavp.entity.VehicleMaintenanceCategory;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.VehicleMaintenanceCategoryMapper;
import com.firmavp.repository.VehicleMaintenanceCategoryRepository;
import com.firmavp.service.VehicleMaintenanceCategoryService;

@Service
public class VehicleMaintenanceCategoryServiceImpl implements VehicleMaintenanceCategoryService {

	private final VehicleMaintenanceCategoryRepository vehicleMaintenanceCategoryRepository;
	private final VehicleMaintenanceCategoryMapper vehicleMaintenanceCategoryMapper;

	@Autowired
	public VehicleMaintenanceCategoryServiceImpl(
			VehicleMaintenanceCategoryRepository vehicleMaintenanceCategoryRepository,
			VehicleMaintenanceCategoryMapper vehicleMaintenanceCategoryMapper) {
		super();
		this.vehicleMaintenanceCategoryRepository = vehicleMaintenanceCategoryRepository;
		this.vehicleMaintenanceCategoryMapper = vehicleMaintenanceCategoryMapper;
	}

	@Override
	@Transactional
	public VehicleMaintenanceCategoryDTO save(VehicleMaintenanceCategoryDTO vehicleMaitenanceCategoryDTO) {
		VehicleMaintenanceCategory vmc = vehicleMaintenanceCategoryRepository
				.save(vehicleMaintenanceCategoryMapper.toVehicleMaintenanceCategory(vehicleMaitenanceCategoryDTO));
		return vehicleMaintenanceCategoryMapper.toVehicleMaintenanceCategoryDTO(vmc);
	}

	@Override
	@Transactional(readOnly = true)
	public VehicleMaintenanceCategoryDTO findVehicleMaintenanceCategory(Integer id) {
		VehicleMaintenanceCategory categoryFromDatabase = vehicleMaintenanceCategoryRepository
				.findVehicleMaintenanceCategoryById(id);
		if (categoryFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no category in database fod id " + id)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}

		return vehicleMaintenanceCategoryMapper.toVehicleMaintenanceCategoryDTO(categoryFromDatabase);
	}

	@Override
	@Transactional
	public VehicleMaintenanceCategoryDTO update(Integer id, VehicleMaintenanceCategoryDTO vmcDTO) {
		VehicleMaintenanceCategory categoryFromDatabase = vehicleMaintenanceCategoryRepository
				.findVehicleMaintenanceCategoryById(id);
		if (categoryFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no category in database fod id " + id)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		categoryFromDatabase = vehicleMaintenanceCategoryMapper.toVehicleMaintenanceCategory(vmcDTO);
		categoryFromDatabase.setId(id);
		vehicleMaintenanceCategoryRepository.save(categoryFromDatabase);

		return vehicleMaintenanceCategoryMapper.toVehicleMaintenanceCategoryDTO(categoryFromDatabase);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		VehicleMaintenanceCategory categoryFromDatabase = vehicleMaintenanceCategoryRepository
				.findVehicleMaintenanceCategoryById(id);
		if (categoryFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no category in database fod id " + id)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		vehicleMaintenanceCategoryRepository.delete(categoryFromDatabase);
	}

}
