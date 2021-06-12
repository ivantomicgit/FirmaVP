package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.firmavp.dto.PlaceDTO;
import com.firmavp.entity.Place;
@Component
public class PlaceMapperImpl implements PlaceMapper {

	@Override
	public PlaceDTO toPlaceDTO(Place place) {
		PlaceDTO placeDTO = new PlaceDTO();
		placeDTO.setId(place.getId());
		placeDTO.setPlaceName(place.getPlaceName());
		placeDTO.setPlaceAddress(place.getPlaceAddress());
		placeDTO.setPlaceContact(place.getPlaceContact());
		placeDTO.setPlaceColor(place.getPlaceColor());

		return placeDTO;
	}

	@Override
	public List<PlaceDTO> toListPlacesDTO(List<Place> listPlaces) {
		List<PlaceDTO> listPlacesDTO = new ArrayList<PlaceDTO>();
		for(Place m : listPlaces) {
			PlaceDTO placeDTO = new PlaceDTO();
			placeDTO.setId(m.getId());
			placeDTO.setPlaceName(m.getPlaceName());
			placeDTO.setPlaceAddress(m.getPlaceAddress());
			placeDTO.setPlaceContact(m.getPlaceContact());
			placeDTO.setPlaceColor(m.getPlaceColor());
			listPlacesDTO.add(placeDTO);
		}
		
		return listPlacesDTO;
	}

	@Override
	public Place toPlace(PlaceDTO placeDTO) {
		Place place = new Place();
		place.setId(placeDTO.getId());
		place.setPlaceName(placeDTO.getPlaceName());
		place.setPlaceAddress(placeDTO.getPlaceAddress());
		place.setPlaceContact(placeDTO.getPlaceContact());
		place.setPlaceColor(placeDTO.getPlaceColor());
		
		return place;
	}

	@Override
	public List<Place> toListPlaces(List<PlaceDTO> listPlacesDTO) {
		List<Place> listPlaces = new ArrayList<Place>();
		for(PlaceDTO pDTO : listPlacesDTO) {
			Place place = new Place();
			place.setId(pDTO.getId());
			place.setPlaceName(pDTO.getPlaceName());
			place.setPlaceAddress(pDTO.getPlaceAddress());
			place.setPlaceContact(pDTO.getPlaceContact());
			place.setPlaceColor(pDTO.getPlaceColor());
			listPlaces.add(place);			
		}
		
		return listPlaces;
	}

}
