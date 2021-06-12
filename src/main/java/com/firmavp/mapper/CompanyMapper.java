package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.CompanyDTO;
import com.firmavp.entity.Company;

public interface CompanyMapper {
	
	CompanyDTO toCompanyDTO(Company company);

	Company toCompany(CompanyDTO companyDTO);

	List<CompanyDTO> toCompanyListDTO(List<Company> companyList);

}
