package com.firmavp.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.WarehouseOutputDTO;
import com.firmavp.entity.WarehouseOutput;
import com.firmavp.entity.Product;
import com.firmavp.entity.WarehouseInput;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.WarehouseOutputMapper;
import com.firmavp.repository.WarehouseOutputRepository;
import com.firmavp.repository.ProductRepository;

import com.firmavp.service.WarehouseOutputService;

@Service
public class WarehouseOutputServiceImpl implements WarehouseOutputService{
	private final WarehouseOutputRepository warehouseOutputRepository;
	private final WarehouseOutputMapper warehouseOutputMapper;
	private final ProductRepository productRepository;
	@Autowired
	public WarehouseOutputServiceImpl(WarehouseOutputRepository warehouseOutputRepository, WarehouseOutputMapper warehouseOutputMapper,
			ProductRepository productRepository) {
		super();
		this.warehouseOutputRepository = warehouseOutputRepository;
		this.warehouseOutputMapper = warehouseOutputMapper;
		this.productRepository = productRepository;
	}

	@Override
	@Transactional
	public WarehouseOutputDTO save(WarehouseOutput warehouseOutput) {
		warehouseOutput = warehouseOutputRepository.save(warehouseOutput);
		return warehouseOutputMapper.toWarehouseOutputDTO(warehouseOutput);
	
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		warehouseOutputRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<WarehouseOutput> listOfOutputs() {
	
		return warehouseOutputRepository.findAll();
	}

	/*
	@Override
	@Transactional
	public WarehouseOutputDTO updateIzlaz(Integer idProizvoda, WarehouseOutputDTO izlazMagacinDTO) {
		Product proizvod = proizvodRepository.findProizvodById(idProizvoda);
		if(proizvod == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("ne postoji proizvod za id " +idProizvoda).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		WarehouseOutput izlazMagacin=izlazMagacinMapper.toIzlazMagacin(izlazMagacinDTO);
		try {
			izlazMagacin.setKolicina(izlazMagacinDTO.getKolicina());
			izlazMagacin.setVremeIzlaza(izlazMagacinDTO.getVremeIzlaza());
			izlazMagacin.setProizvod(proizvod);
			izlazMagacinRepository.save(izlazMagacin);
		} catch (Exception e) {
			throw new EntityNotFoundException("nije sacuvan podatak");
		}
		return izlazMagacinMapper.toIzlazMagacinDTO(izlazMagacin);
	}
	
	*/
}

