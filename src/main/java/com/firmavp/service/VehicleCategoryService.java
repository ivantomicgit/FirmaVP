package com.firmavp.service;

import java.util.List;

import com.firmavp.dto.VehicleCategoryDTO;
import com.firmavp.entity.VehicleCategory;

public interface VehicleCategoryService {

	VehicleCategory save(VehicleCategory kategorijeVozila);

	List<VehicleCategoryDTO> findAll();

	VehicleCategoryDTO findKategorijeVozila(Integer id);

	VehicleCategory update(Integer id, VehicleCategory kategorijeVozila);

	void delete(Integer id);

	

}
