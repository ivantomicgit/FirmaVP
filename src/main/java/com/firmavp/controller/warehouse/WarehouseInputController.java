package com.firmavp.controller.warehouse;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firmavp.dto.CompanyDTO;
import com.firmavp.dto.ProductDTO;
import com.firmavp.dto.WarehouseInputDTO;
import com.firmavp.entity.WarehouseInput;
import com.firmavp.fasada.WarehouseInputFacade;
import com.firmavp.mapper.WarehouseInputMapper;
import com.firmavp.service.ProductService;
import com.firmavp.service.WarehouseInputService;

@RestController
@RequestMapping("/api/warehouseinput/")
public class WarehouseInputController {
	private final WarehouseInputService inputService;
	private final WarehouseInputMapper inputMapper;
	private final WarehouseInputFacade inputFacade;
	private final ProductService productService;
	@Autowired
	public WarehouseInputController(WarehouseInputService inputService, WarehouseInputMapper inputMapper,
			WarehouseInputFacade inputFacade, ProductService productService) {
		super();
		this.inputService = inputService;
		this.inputMapper =inputMapper;
		this.inputFacade = inputFacade;
		this.productService =productService;
	}

	@PostMapping("/create/{idWarehouse}")
	public ResponseEntity<?>createInput(@PathVariable Integer idWarehouse, @RequestBody  List<WarehouseInputDTO> warehouseInputDTO){
		warehouseInputDTO=inputFacade.save(warehouseInputDTO,idWarehouse);

		return new ResponseEntity <List<WarehouseInputDTO>>(warehouseInputDTO,HttpStatus.OK);
	

}

	@GetMapping("/listOfInputs")
	public ResponseEntity<List<WarehouseInput>>findAll() {
	
		return new ResponseEntity<List<WarehouseInput>>(inputService.listOfInputs(),HttpStatus.OK); 
}




	  @DeleteMapping("/deleteInput/{id}")   
	  public  ResponseEntity<String>obrisiUlaz(@PathVariable Integer id) {
		 
		  inputFacade.deleteById(id);
		
		  return new ResponseEntity<String>("delete  input for id" +id,HttpStatus.OK);
	  }
	  
	/*  @GetMapping("/product/inputsList/{id}")
		public ResponseEntity<ProductDTO>listOfInputsForCompany(@PathVariable Integer id){
			ProductDTO productDTO = productService.findProductByDTOId(id);
			
			return new ResponseEntity<ProductDTO>(productDTO,HttpStatus.OK);*/
/*	  @PutMapping("/updateInput/{idProduct}")   
	  public ResponseEntity<WarehouseInputDTO> updateInput(@PathVariable Integer idProduct,@RequestBody WarehouseInputDTO warehouseInputDTO){
		  
		  return new ResponseEntity<WarehouseInputDTO>(ulazService.updateUlaz(idProizvoda,ulazMagacinDTO),HttpStatus.OK);*/
		  
	  }
	  



