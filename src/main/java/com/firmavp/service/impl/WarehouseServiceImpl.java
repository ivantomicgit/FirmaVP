package com.firmavp.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.WarehouseDTO;
import com.firmavp.entity.Address;
import com.firmavp.entity.Company;
import com.firmavp.entity.Warehouse;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.CompanyMapper;
import com.firmavp.mapper.WarehouseMapper;
import com.firmavp.repository.WarehouseRepository;
import com.firmavp.service.AddressService;
import com.firmavp.service.CompanyService;
import com.firmavp.service.WarehouseService;
@Service
public class WarehouseServiceImpl implements WarehouseService{

	private final WarehouseRepository warehouseRepository;
	private final WarehouseMapper warehouseMapper;
	private final AddressService adressService;
	private final CompanyService companyService;
	private final CompanyMapper companyMapper;
	
	@Autowired
	public WarehouseServiceImpl(WarehouseRepository warehouseRepository, WarehouseMapper warehouseMapper,CompanyService companyService,CompanyMapper companyMapper,AddressService adressService) {
		super();
		this.warehouseRepository = warehouseRepository;
		this.warehouseMapper = warehouseMapper;
		this.adressService=adressService;
		this.companyMapper=companyMapper;
		this.companyService=companyService;
	}

	@Override
	@Transactional
	public WarehouseDTO save(Warehouse warehouse) {
       warehouse = warehouseRepository.save(warehouse);
		return warehouseMapper.toWarehouseDTO(warehouse);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		warehouseRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public List<Warehouse> findAll() {
		
		return warehouseRepository.findAll();
	}

	@Override
	@Transactional
	public WarehouseDTO updateWarehouse(Integer idAdress, Integer idCompany, WarehouseDTO warehouseDTO) {

		Address databaseAdress = adressService.findAddressById(idAdress);
 		if (databaseAdress == null) {
     		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("adress for id does not exist " +idAdress).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
 		}
 		
 		Company databaseCompany = companyMapper.toCompany(companyService.findCompany(idCompany));
 		//
 		if (databaseCompany == null) {
     		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("company does not exist for id " +idCompany).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
 		}
 		Warehouse warehouse = warehouseMapper.toWarehouse(warehouseDTO);
 		 try {
 			 


 			 warehouse.setAddress(databaseAdress);

 			 warehouse.setCompany(databaseCompany);
 			 warehouse.setNameWarehouse(warehouseDTO.getNameWarehouse());
 			 warehouseRepository.save(warehouse);
 			 }catch (Exception e) {
 	     		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("data not saved").withError_code("NOT_SAVED").withStatus(HttpStatus.BAD_REQUEST).build();
 			}
 			 
 				return warehouseMapper.toWarehouseDTO(warehouse);
 			}


	@Override
	@Transactional
	public List<Warehouse> findWarehouseByNameWarehouse(String name) {
		List<Warehouse>list = warehouseRepository.findWarehouseByNameWarehouse(name);
		if(list.size() == 0) {
     		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no warehouse for that name " +name).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

		}
		return list;
	}


	@Override
	@Transactional
	public Warehouse findWarehouseById(Integer idWarehouse) {
		Warehouse warehouse = warehouseRepository.findWarehouseById(idWarehouse);
		if(warehouse == null) {
     		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no warehouse for id " +idWarehouse).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

		}
		return warehouse;
	}


	@Override
	public void deleteAll(List<WarehouseDTO> list) {
     
		List<Warehouse>listWarehouse = warehouseMapper.toWarehouses(list);
	     for(Iterator<Warehouse>iterator = listWarehouse.iterator();iterator.hasNext();){
	    	 Warehouse warehouse = iterator.next();
	    	 warehouseRepository.deleteById(warehouse.getId());
	     }
		}
	}
	
	
	


