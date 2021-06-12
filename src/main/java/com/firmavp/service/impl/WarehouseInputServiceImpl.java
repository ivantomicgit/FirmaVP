package com.firmavp.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.WarehouseInputDTO;
import com.firmavp.entity.Product;
import com.firmavp.entity.WarehouseInput;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.WarehouseInputMapper;
import com.firmavp.repository.ProductRepository;
import com.firmavp.repository.WarehouseInputRepository;
import com.firmavp.service.WarehouseInputService;

@Service
public class WarehouseInputServiceImpl  implements WarehouseInputService{
private final WarehouseInputRepository warehouseInputRepository;
private final WarehouseInputMapper warehouseInputMapper;
private final ProductRepository productRepository;
     @Autowired
	public WarehouseInputServiceImpl(WarehouseInputRepository warehouseInputRepository,WarehouseInputMapper warehouseInputMapper,ProductRepository productRepository) {
	super();
	this.warehouseInputRepository = warehouseInputRepository;
	this.warehouseInputMapper = warehouseInputMapper;
	this.productRepository = productRepository;
}
	@Override
	@Transactional
	public WarehouseInputDTO save(WarehouseInput warehouseInput) {
		warehouseInput = warehouseInputRepository.save(warehouseInput);
		return warehouseInputMapper.toWarehouseInputDTO(warehouseInput);
	}
	@Override

	public List<WarehouseInput> listOfInputs() {
		
		return warehouseInputRepository.findAll();
	}
	@Override
	@Transactional
	public void deleteById(Integer id) {
		warehouseInputRepository.deleteById(id);
		
	}
	/*
	@Override
	public WarehouseInputDTO updateInput(Integer idProizvoda, WarehouseInputDTO ulazMagacinDTO) {
		Product proizvod = proizvodRepository.findProizvodById(idProizvoda);
		if(proizvod == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("ne postoji proizvod za id " +idProizvoda).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		WarehouseInput ulazMagacin=ulazMagacinMapper.toUlazMagacin(ulazMagacinDTO);
		try {
			ulazMagacin.setKolicina(ulazMagacinDTO.getKolicina());
			ulazMagacin.setVremeUlaza(ulazMagacinDTO.getVremeUlaza());
			ulazMagacin.setProizvod(proizvod);
			ulazMagacinRepository.save(ulazMagacin);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("nije sacuvan podatak").withError_code("NOT_SAVED").withStatus(HttpStatus.BAD_REQUEST).build();
		}
		return ulazMagacinMapper.toUlazMagacinDTO(ulazMagacin);
	}

*/
}
