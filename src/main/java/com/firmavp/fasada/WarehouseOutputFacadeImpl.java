package com.firmavp.fasada;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.firmavp.dto.WarehouseOutputDTO;


import com.firmavp.entity.WarehouseOutput;
import com.firmavp.entity.Product;
import com.firmavp.entity.Warehouse;


import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.WarehouseOutputMapper;
import com.firmavp.service.WarehouseOutputService;
import com.firmavp.service.WarehouseService;
import com.firmavp.service.ProductService;


@Component
public class WarehouseOutputFacadeImpl implements WarehouseOutputFacade {
	 private final WarehouseOutputMapper warehouseOutputMapper;
	 private final WarehouseOutputService outputService;
	private final ProductService productService;
	private final WarehouseService warehouseService;
	   @Autowired
	  public WarehouseOutputFacadeImpl(WarehouseOutputMapper warehouseOutputMapper, WarehouseOutputService outputService,
			ProductService productService,WarehouseService warehouseService) {
		super();
		this.warehouseOutputMapper = warehouseOutputMapper;
		this.outputService = outputService;
		this.productService = productService;
		this.warehouseService= warehouseService;
	}


	@Override
	public List<WarehouseOutputDTO> save(List<WarehouseOutputDTO> warehouseOutputDTO,Integer idWarehouse) {
		List<WarehouseOutputDTO>list = new ArrayList<WarehouseOutputDTO>();
		for(WarehouseOutputDTO dro : warehouseOutputDTO) {
			Product product = productService.findProductById(dro.getIdProduct());
			if(product == null) {
				//throw new EntityNotFoundException("ne postoji proizvod za id " +idProizvoda);
				throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withMessage("")
				.withDetail("no product for id " +dro.getIdProduct()).build();
			}
			Warehouse warehouse =warehouseService.findWarehouseById(idWarehouse);
			if(warehouse == null) {
	    		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no warehouse for id " +idWarehouse).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
			}
			WarehouseOutput warehouseOutput = new WarehouseOutput();
			
			warehouseOutput.setAmount(dro.getAmount());
			warehouseOutput.setProduct(product);
			warehouseOutput.setWarehouse(warehouse);
			warehouseOutput.setOutputTime(dro.getOutputTime());
			list.add( outputService.save(warehouseOutput));
			
		}
		
		
	
		return list;
	}
	

	@Override
	public void deleteById(Integer id) {
		outputService.deleteById(id);
		
	}

}
