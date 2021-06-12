package com.firmavp.controller.warehouse;

import java.util.List;

import javax.persistence.EntityNotFoundException;

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
import com.firmavp.dto.ProductCategoryDTO;
import com.firmavp.mapper.ProductCategoryMapper;
import com.firmavp.service.ProductCategoryService;

@RestController
@RequestMapping("/api/productcategory")
public class ProductCategoryController {

	private final ProductCategoryService categoryService;
	private final ProductCategoryMapper categoryMapper;

	@Autowired
	public ProductCategoryController(ProductCategoryService categoryService, ProductCategoryMapper categoryMapper) {
		super();
		this.categoryService = categoryService;
		this.categoryMapper = categoryMapper;
	}

	@PostMapping("/create")
	public ResponseEntity<ProductCategoryDTO> create(@RequestBody ProductCategoryDTO productCategoryDTO) {

		return new ResponseEntity<ProductCategoryDTO>(categoryService.save(productCategoryDTO), HttpStatus.CREATED);

	}
	
	
	@GetMapping("/read/{id}")
	public ResponseEntity<ProductCategoryDTO> read(@PathVariable Integer id) {

		ProductCategoryDTO productCategoryDTO = null;
		try {
			productCategoryDTO = categoryService.findProductCategory(id);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<ProductCategoryDTO>( productCategoryDTO , HttpStatus.OK);

	}
	
	@GetMapping("/readlist")
	public ResponseEntity<?> readList() {
		List<ProductCategoryDTO> listProductCategoryDTO = categoryMapper.toProductCategoryListDTO(categoryService.findAll());

		return new ResponseEntity<List<ProductCategoryDTO>>(listProductCategoryDTO, HttpStatus.OK);

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductCategoryDTO> update(@PathVariable Integer id, @RequestBody ProductCategoryDTO productCategoryDTO) {

		return new ResponseEntity<ProductCategoryDTO>(categoryService.update(id, productCategoryDTO), HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFirma(@PathVariable Integer id) {
		categoryService.delete(id);
		return new ResponseEntity<String>("Category with id " + id + "is deleted", HttpStatus.OK);

	}
	
	
	
	
	

}
