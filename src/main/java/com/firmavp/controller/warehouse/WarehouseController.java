package com.firmavp.controller.warehouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firmavp.dto.CompanyDTO;

import com.firmavp.dto.WarehouseDTO;
import com.firmavp.entity.Warehouse;
import com.firmavp.entity.WarehouseInput;
import com.firmavp.fasada.WarehouseFacade;
import com.firmavp.mapper.WarehouseMapper;
import com.firmavp.service.CompanyService;

import com.firmavp.service.WarehouseService;


@RestController
@RequestMapping("/api/warehouse/")
public class WarehouseController {
	
private final WarehouseFacade warehouseFacade;
private final WarehouseService warehouseService;
private final WarehouseMapper mapper;
private final CompanyService companyService;

	
	@Autowired
	public WarehouseController(WarehouseFacade warehouseFacade, WarehouseService warehouseService, WarehouseMapper mapper,CompanyService companyService) {
	super();
	this.warehouseFacade = warehouseFacade;
	this.warehouseService = warehouseService;
	this.mapper=mapper;
	this.companyService=companyService;
}



	@PostMapping("/create/{idCompany}/{idAdress}")
	public ResponseEntity<?>create(@PathVariable Integer idCompany,@PathVariable Integer idAdress, @RequestBody WarehouseDTO warehouseDTO){
		warehouseDTO=warehouseFacade.save(warehouseDTO,idCompany,idAdress);

		return new ResponseEntity<WarehouseDTO>(warehouseDTO,HttpStatus.OK);
}
	  @DeleteMapping("/delete/{id}")   
	  public  ResponseEntity<String>deleteWarehouse(@PathVariable Integer id) {
		 
		 warehouseFacade.deleteById(id);
		
		  return new ResponseEntity<String>("warehouse deleted" +id,HttpStatus.OK);
	  }
		@GetMapping("/warehousesList/")
		public ResponseEntity<List<WarehouseDTO>>findAll(){
			List<WarehouseDTO>listWarehouseDTO = mapper.toWarehouseDTOs(warehouseService.findAll());		
				
			return new ResponseEntity<List<WarehouseDTO>>(listWarehouseDTO,HttpStatus.OK);
			
}
		@PutMapping("/updateWarehouse/{idCompany}/{idAdress}")   // 
		  public ResponseEntity<WarehouseDTO> updateWarehouse(@PathVariable Integer idAdress,@PathVariable Integer idCompany,@RequestBody WarehouseDTO warehouseDTO){
			
			  
			  return    new  ResponseEntity<WarehouseDTO>(warehouseService.updateWarehouse(idAdress,idCompany,warehouseDTO),HttpStatus.OK);
			  
			  
		  }
		@GetMapping("/company/listWarehouses/{id}")
		public ResponseEntity<CompanyDTO>listWarehousesForCompany(@PathVariable Integer id){
			CompanyDTO companyDTO = companyService.findCompanyByDTOId(id);
			
			return new ResponseEntity<CompanyDTO>(companyDTO,HttpStatus.OK);
		
}
		@GetMapping("/name/{name}")
		public ResponseEntity<List<WarehouseDTO>>findWarehouseByName(@PathVariable String name){
	    	List<WarehouseDTO>list =mapper.toWarehouseDTOs(warehouseService.findWarehouseByNameWarehouse(name));	    	
	    	
	    	return new ResponseEntity<List<WarehouseDTO>>(list,HttpStatus.OK);
	    
	
	
 }
		  @DeleteMapping("/deleteWarehouses")    
		  public  ResponseEntity<String>deleteWarehouses(@RequestBody List<WarehouseDTO>list) {
			  
			  warehouseService.deleteAll(list);
			  
			  return new ResponseEntity<String>("warehouses deleted",HttpStatus.OK);
		  }
}
		
		
		
		