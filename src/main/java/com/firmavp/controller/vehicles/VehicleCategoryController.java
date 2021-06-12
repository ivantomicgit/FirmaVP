package com.firmavp.controller.vehicles;

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

import com.firmavp.dto.VehicleCategoryDTO;
import com.firmavp.entity.VehicleCategory;
import com.firmavp.service.VehicleCategoryService;

@RestController
@RequestMapping("/api/vehiclecategory")
public class VehicleCategoryController {

	private VehicleCategoryService categoryService;

	@Autowired
	public VehicleCategoryController(VehicleCategoryService kategorijeService) {
		super();
		this.categoryService = kategorijeService;
	}

	@PostMapping("/create")
	public ResponseEntity<VehicleCategory> create(@RequestBody VehicleCategory kategorijeVozila) {

		return new ResponseEntity<VehicleCategory>(categoryService.save(kategorijeVozila), HttpStatus.CREATED);

	}
		
	@GetMapping("/readlist")
	public ResponseEntity<?> readList() {
		List<VehicleCategoryDTO> listKategorijeVozila = categoryService.findAll();

		return new ResponseEntity<List<VehicleCategoryDTO>>(listKategorijeVozila, HttpStatus.OK);
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<VehicleCategoryDTO> read(@PathVariable Integer id) {
		
		VehicleCategoryDTO vehicleCategoryDTO =  categoryService.findKategorijeVozila(id);

		return new ResponseEntity<VehicleCategoryDTO>(vehicleCategoryDTO,  HttpStatus.OK);
	}
		
	@PutMapping("/update/{id}")
	public ResponseEntity<VehicleCategory> update(@PathVariable Integer id, @RequestBody VehicleCategory kategorijeVozila) {

		return new ResponseEntity<VehicleCategory>(categoryService.update(id, kategorijeVozila), HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		
		categoryService.delete(id);
		return new ResponseEntity<String>("Kategorija vozila za id " + id + " je izbrisana", HttpStatus.OK);

	}
	
	
	
	
	
	
	
	

}
