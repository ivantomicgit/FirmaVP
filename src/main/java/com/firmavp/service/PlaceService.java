package com.firmavp.service;

import java.util.List;

import com.firmavp.dto.PlaceDTO;
import com.firmavp.entity.Place;

public interface PlaceService {

	List<Place> findAll();

	PlaceDTO save(PlaceDTO placeDTO, Integer idCompany);

	void delete(Integer id);

	PlaceDTO updateMesto(PlaceDTO placeDTO, Integer idCompany);

	Place findPlace(Integer id);

	

}
