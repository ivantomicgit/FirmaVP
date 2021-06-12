package com.firmavp.service;

import java.util.List;

import com.firmavp.dto.CompanyDTO;
import com.firmavp.entity.Company;

public interface CompanyService {

	

	void delete(Integer id);

	CompanyDTO update(Integer id, CompanyDTO firmaDTO);

	CompanyDTO findCompany(Integer id);

	List<Company> findAll();

	CompanyDTO save(CompanyDTO companyDTO, Integer adressId);

	CompanyDTO findCompanyByDTOId(Integer id);

}
