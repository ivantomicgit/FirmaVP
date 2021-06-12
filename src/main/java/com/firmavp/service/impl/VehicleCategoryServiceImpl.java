package com.firmavp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.VehicleCategoryDTO;
import com.firmavp.entity.VehicleCategory;
import com.firmavp.repository.VehicleCategoryRepository;
import com.firmavp.service.VehicleCategoryService;

import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.VehicleCategoryMapper;


@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

	private final VehicleCategoryRepository kategorijeRepository;
	private final VehicleCategoryMapper categoryMapper;

	@Autowired
	public VehicleCategoryServiceImpl(VehicleCategoryRepository kategorijeRepository, VehicleCategoryMapper categoryMapper) {
		super();
		this.kategorijeRepository = kategorijeRepository;
		this.categoryMapper = categoryMapper;
	}

	@Override
	@Transactional
	public VehicleCategory save(VehicleCategory kategorijeVozila) {
		// TODO Auto-generated method stub
		return kategorijeRepository.save(kategorijeVozila);
	}

	@Override
	@Transactional(readOnly = true)
	public List<VehicleCategoryDTO> findAll() {
		// TODO Auto-generated method stub
		return categoryMapper.toListVehicleCategoryDTO(kategorijeRepository.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public VehicleCategoryDTO findKategorijeVozila(Integer id) {
		VehicleCategory kategorijeVozila = kategorijeRepository.findVehicleCategoryById(id);

		if (kategorijeVozila == null) {

			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no category for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}

		return categoryMapper.toVehicleCategoryDTO(kategorijeVozila);
	}

	@Override
	@Transactional
	public VehicleCategory update(Integer id, VehicleCategory kategorijeVozila) {

		VehicleCategory kategorijeVozilaBaza = kategorijeRepository.findVehicleCategoryById(id);
		if (kategorijeVozilaBaza == null) {

			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no category for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		kategorijeVozila.setId(id);
		return kategorijeRepository.save(kategorijeVozila);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		VehicleCategory kategorijeVozilaBaza = kategorijeRepository.findVehicleCategoryById(id);
		if (kategorijeVozilaBaza == null) {

			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no category for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		
		kategorijeRepository.deleteById(id);
	}

	
	
	
	

	
	
	
}
