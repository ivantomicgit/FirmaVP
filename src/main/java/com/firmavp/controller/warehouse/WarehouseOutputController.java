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

import com.firmavp.dto.WarehouseOutputDTO;
import com.firmavp.entity.WarehouseOutput;
import com.firmavp.fasada.WarehouseOutputFacade;
import com.firmavp.mapper.WarehouseOutputMapper;
import com.firmavp.service.WarehouseOutputService;
import com.firmavp.service.ProductService;



@RestController
@RequestMapping("/api/warehouseoutput/")
public class WarehouseOutputController {
	private final WarehouseOutputService outputService;
	private final WarehouseOutputMapper outputMapper;
	private final WarehouseOutputFacade outputFacade;
	private final ProductService productService;
	@Autowired
	public WarehouseOutputController(WarehouseOutputService outputService, WarehouseOutputMapper outputMapper,
			WarehouseOutputFacade outputFacade, ProductService productService) {
		super();
		this.outputService = outputService;;
		this.outputMapper = outputMapper;
		this.outputFacade = outputFacade;
		this.productService = productService;
	}

	@PostMapping("/create/{idWarehouse}")
	public ResponseEntity<?>createOutput(@PathVariable Integer idWarehouse, @RequestBody List<WarehouseOutputDTO> warehouseOutputDTO){
		
		warehouseOutputDTO=outputFacade.save(warehouseOutputDTO,idWarehouse);
		
	return new ResponseEntity <List<WarehouseOutputDTO>>(warehouseOutputDTO,HttpStatus.OK);
		//System.out.println(warehouseOutputDTO.size());
	//	return null;
	

}
	@GetMapping("/listOfOutputs")
	public ResponseEntity<List<WarehouseOutput>>findAll() {
	
		return new ResponseEntity<List<WarehouseOutput>>(outputService.listOfOutputs(),HttpStatus.OK); 
}
	  @DeleteMapping("/deleteOutput/{id}")   
	  public  ResponseEntity<String>deleteOutput(@PathVariable Integer id) {
		  
		outputFacade.deleteById(id);
		  
		  return new ResponseEntity<String>("delete  output for id"+id,HttpStatus.OK);
	  }
	/*  @PutMapping("/updateIzlaza/{idProizvoda}")   
	  public ResponseEntity<WarehouseOutputDTO> updateIzlaza(@PathVariable Integer idProizvoda,@RequestBody WarehouseOutputDTO izlazMagacinDTO){
		
		  
		  return    new  ResponseEntity<WarehouseOutputDTO>(izlazService.updateIzlaz(idProizvoda,izlazMagacinDTO),HttpStatus.OK);
		  */
		  
	  }


