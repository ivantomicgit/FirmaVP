package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.CompanyDTO;
import com.firmavp.entity.Company;

@Component
public class CompanyMapperImpl implements CompanyMapper {

	private PlaceMapper mestoMapper;
	private WarehouseMapper warehouseMapper;

	@Autowired
	public CompanyMapperImpl(PlaceMapper mestoMapper,WarehouseMapper warehouseMapper) {
		super();
		this.mestoMapper = mestoMapper;
		this.warehouseMapper=warehouseMapper;
	}

	@Override
	public CompanyDTO toCompanyDTO(Company company) {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setId(company.getId());
		companyDTO.setCompanyName(company.getCompanyName());
		companyDTO.setListPlacesDTO(mestoMapper.toListPlacesDTO(company.getListPlaces()));
		companyDTO.setListWarehouseDTOs(warehouseMapper.toWarehouseDTOs(company.getListWarehouses()));
		return companyDTO;
	}

	@Override
	public Company toCompany(CompanyDTO companyDTO) {
		Company company = new Company();
		company.setId(companyDTO.getId());
		company.setCompanyName(companyDTO.getCompanyName());
		company.setListPlaces(mestoMapper.toListPlaces(companyDTO.getListPlacesDTO()));
		company.setListWarehouses(warehouseMapper.toWarehouses(companyDTO.getListWarehouseDTOs()));
		return company;
	}

	@Override
	public List<CompanyDTO> toCompanyListDTO(List<Company> companyList) {
		 List<CompanyDTO> listCompanyDTO = new ArrayList<CompanyDTO>();
		 for(Company f : companyList) {
			 CompanyDTO companyDTO = new CompanyDTO();
			 companyDTO.setId(f.getId());
			 companyDTO.setCompanyName(f.getCompanyName());
			 companyDTO.setListPlacesDTO(mestoMapper.toListPlacesDTO(f.getListPlaces()));
			 companyDTO.setListWarehouseDTOs(warehouseMapper.toWarehouseDTOs(f.getListWarehouses()));
			 listCompanyDTO.add(companyDTO);
		 }
		
		 return listCompanyDTO;
	}

}
