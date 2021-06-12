package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.PlaceDTO;
import com.firmavp.entity.Place;

public interface PlaceMapper {

	PlaceDTO toPlaceDTO(Place place); 
	
	List<PlaceDTO> toListPlacesDTO(List<Place> listPlaces);
	
	Place toPlace(PlaceDTO placeDTO);
	
	List<Place> toListPlaces(List<PlaceDTO> listPlacesDTO);
	
	
}
