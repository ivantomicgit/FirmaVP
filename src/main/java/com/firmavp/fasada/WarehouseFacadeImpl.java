package com.firmavp.fasada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.firmavp.dto.WarehouseDTO;
import com.firmavp.entity.Address;

import com.firmavp.entity.Company;
import com.firmavp.entity.Warehouse;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.CompanyMapper;

import com.firmavp.mapper.WarehouseMapper;
import com.firmavp.service.AddressService;

import com.firmavp.service.CompanyService;

import com.firmavp.service.WarehouseService;

@Component
public class WarehouseFacadeImpl  implements WarehouseFacade{
	private final WarehouseService warehouseService;
	private final WarehouseMapper warehouseMapper;
	private final AddressService adressService;
	private final CompanyService companyService;
	private final CompanyMapper companyMapper;
    @Autowired
	public WarehouseFacadeImpl(WarehouseService warehouseService, WarehouseMapper warehouseMapper,
			AddressService adressService, CompanyService companyService, CompanyMapper companyMapper) {
		super();
		this.warehouseService = warehouseService;
		this.warehouseMapper = warehouseMapper;
		this.adressService = adressService;
		this.companyService = companyService;
		this.companyMapper=companyMapper;
	}
 // Refactoring

 	public Address getAndCheckAddres(Integer idAdress) {
 		Address databaseAdress = adressService.findAddressById(idAdress);
 		if (databaseAdress == null) {
     		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("adress for id does not exist " +idAdress).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

 		}
 		return databaseAdress;
 	}

 	public Company getAndCheckCompany(Integer idCompany) {
 		Company  databaseCompany = companyMapper.toCompany(companyService.findCompany(idCompany));
 		if (databaseCompany == null) {
     		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("company does not exist for id " +idCompany).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

 		}
 		return databaseCompany;
 	}

	@Override
	public WarehouseDTO save(WarehouseDTO warehouseDTO, Integer idCompany, Integer idAdress) {
		Address adress= getAndCheckAddres(idAdress);
		Company company = getAndCheckCompany(idCompany);
		 
		Warehouse warehouse = new Warehouse();
		warehouse.setNameWarehouse(warehouseDTO.getNameWarehouse());
		warehouse.setAddress(adress);
		warehouse.setCompany(company);
		WarehouseDTO warehouseDTOsave = warehouseService.save(warehouse);
				
		return warehouseDTOsave;
	}

	

	@Override
	public void deleteById(Integer id) {
		try {
			warehouseService.deleteById(id);
			}
			catch (Exception e) {
	    		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("doesnt exist warehouse for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

			}
			
		}
		
	}


