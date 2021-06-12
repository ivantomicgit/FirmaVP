package com.firmavp.fasada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


import com.firmavp.dto.WarehouseInputDTO;
import com.firmavp.entity.Product;
import com.firmavp.entity.Warehouse;
import com.firmavp.entity.WarehouseInput;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.WarehouseInputMapper;
import com.firmavp.service.ProductService;
import com.firmavp.service.WarehouseInputService;
import com.firmavp.service.WarehouseService;

@Component
public class WarehouseInputFacadeImpl implements  WarehouseInputFacade {
 private final WarehouseInputMapper warehouseInputMapper;
private final WarehouseInputService inputService;
 private final ProductService productService;
 private final WarehouseService warehouseService;
 
 @Autowired
 public WarehouseInputFacadeImpl(WarehouseInputMapper warehouseInputMapper,WarehouseInputService inputService, ProductService productService,WarehouseService warehouseService) {
	super();
	this.warehouseInputMapper = warehouseInputMapper;
    this.inputService = inputService;
	this.productService=productService;
	this.warehouseService=warehouseService;
}

	@Override
	public List<WarehouseInputDTO> save(List<WarehouseInputDTO>  warehouseInputDTO,Integer idWarehouse) {
		List<WarehouseInputDTO>list = new ArrayList<WarehouseInputDTO>();
		for(WarehouseInputDTO dto : warehouseInputDTO) {
			Product product= productService.findProductById(dto.getIdProduct());
		if(product == null) {
    		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no product for id " +dto.getIdProduct()).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

		}
		Warehouse warehouse =warehouseService.findWarehouseById(idWarehouse);
		if(warehouse == null) {
    		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no warehouse for id " +idWarehouse).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

		}
		WarehouseInput warehouseInput = new WarehouseInput();
		warehouseInput.setAmount(dto.getAmount());
		warehouseInput.setProduct(product);
		warehouseInput.setWarehouse(warehouse);
		warehouseInput.setInputTime(dto.getInputTime());
		list.add(inputService.save(warehouseInput));
		
	}
		return list;
	}
	@Override
	public void deleteById(Integer id) {
		try {
		inputService.deleteById(id);
		}
		catch (Exception e) {
    		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("ne postoji ulaz za id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

		}
		
	}

}
