package com.firmavp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.CompanyDTO;
import com.firmavp.entity.Address;
import com.firmavp.entity.Company;
import com.firmavp.entity.Place;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.AddressMapper;
import com.firmavp.mapper.CompanyMapper;
import com.firmavp.repository.AddressRepository;
import com.firmavp.repository.CompanyRepository;
import com.firmavp.repository.PlaceRepository;
import com.firmavp.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository;
	private final PlaceRepository placeRrepository;
	private final CompanyMapper companyMapper;
	private final AddressMapper adressMapper;
	private final AddressRepository adressRepository;
	
	@Autowired
	public CompanyServiceImpl(CompanyMapper companyMapper, PlaceRepository placeRrepository, CompanyRepository companyRepository,AddressMapper adressMapper,AddressRepository adressRepository) {
		super();
		this.companyRepository = companyRepository;
		this.placeRrepository = placeRrepository;
		this.companyMapper = companyMapper;
		this.adressMapper = adressMapper;
		this.adressRepository=adressRepository;
	}

	
	@Override
	@Transactional
	public CompanyDTO save(CompanyDTO companyDTO,Integer adressId) {
		Address adressFromDatabase=adressRepository.findAddressById(adressId);
		if(adressFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no adress " +adressId).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

		}
		
		Company company = companyMapper.toCompany(companyDTO);	
		company.setAddress(adressFromDatabase);

		return companyMapper.toCompanyDTO(companyRepository.save(company));
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public CompanyDTO findCompany(Integer id) {
		Company companyFromDatabase = companyRepository.findCompanyById(id);
		
		if(companyFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no category for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

		}		
		
		return companyMapper.toCompanyDTO(companyFromDatabase);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Company> findAll() {
		List<Company> listCompany = companyRepository.findAll();
		if(listCompany == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("there isn't any companies ").withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

		}
		return listCompany;
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Company companyFromDatabase = companyRepository.findCompanyById(id);
		
		if(companyFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no company for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		
		companyRepository.deleteById(id);		
	}

	
	@Override
	@Transactional
	public CompanyDTO update(Integer id, CompanyDTO firmaDTO) {
		
		Company company = companyMapper.toCompany(firmaDTO);
		
		company.setId(id);
		Company companyFromDatabase = companyRepository.findCompanyById(id);
		
		if(companyFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no company for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		
		return companyMapper.toCompanyDTO(companyRepository.save(company));
	}


	@Override
	@Transactional
	public CompanyDTO findCompanyByDTOId(Integer id) {
		Company company = companyRepository.findCompanyById(id);
		if(company == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("company does not exist for " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

		}
				
		return companyMapper.toCompanyDTO(company);
	}


	

}
