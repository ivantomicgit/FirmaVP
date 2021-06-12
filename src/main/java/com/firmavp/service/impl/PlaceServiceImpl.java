package com.firmavp.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.PlaceDTO;
import com.firmavp.entity.Company;
import com.firmavp.entity.Place;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.PlaceMapper;
import com.firmavp.repository.CompanyRepository;
import com.firmavp.repository.PlaceRepository;
import com.firmavp.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService {

	private final PlaceRepository placeRepository;
	private final CompanyRepository companyRepository;
	private final PlaceMapper placeMapper;

	@Autowired
	public PlaceServiceImpl(PlaceMapper placeMapper, CompanyRepository companyRepository, PlaceRepository placeRepository) {
		super();
		this.placeRepository = placeRepository;
		this.companyRepository = companyRepository;
		this.placeMapper = placeMapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Place> findAll() {
		// TODO Auto-generated method stub
		return placeRepository.findAll();
	}

	@Override
	@Transactional
	public PlaceDTO save(PlaceDTO placeDTO, Integer idCompany) {
		Company company = companyRepository.findCompanyById(idCompany);
		if (company == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("company does not exist for id " +idCompany).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		Place place = new Place();
		place.setCompany(company);
		place.setPlaceName(placeDTO.getPlaceName());
		place.setPlaceAddress(placeDTO.getPlaceAddress());
		place.setPlaceContact(placeDTO.getPlaceContact());
		place.setPlaceColor(placeDTO.getPlaceColor());

		placeRepository.save(place);
		PlaceDTO placeDTO2 = placeMapper.toPlaceDTO(place);

		return placeDTO2;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Place place = placeRepository.findCompanyById(id);
		if(place == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("place does not exist for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		
		placeRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public PlaceDTO updateMesto(PlaceDTO placeDTO, Integer idCompany) {
		Company company = companyRepository.findCompanyById(idCompany);
		if (company == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("company does not exist for id " +idCompany).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		Place place = placeMapper.toPlace(placeDTO);
		
		try {
			place.setCompany(company);
			
			placeRepository.save(place);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return placeMapper.toPlaceDTO(place);
	}

	@Override
	@Transactional
	public Place findPlace(Integer id) {
		Place place = placeRepository.findCompanyById(id);
		
		if(place == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("place does not exist for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();		
		}
		return place;
	}

	

}
