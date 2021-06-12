package com.firmavp.controller.warehouse;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.firmavp.dto.ProductDTO;


import com.firmavp.enums.PictureCategory;
import com.firmavp.mapper.ProductMapper;
import com.firmavp.service.PicturesService;
import com.firmavp.service.ProductService;

@RestController
@RequestMapping ("/api/product")
@CrossOrigin
public class ProductController {
	private final ProductService productService;
	private final PicturesService picturesService;
	private final ProductMapper productMapper;
    
	@Autowired
	public ProductController(ProductService productService, PicturesService picturesService,
			ProductMapper productMapper) {
		super();
		this.productService = productService;
		this.picturesService = picturesService;
		this.productMapper = productMapper;
	}
	
	
	
	@PostMapping("/create")
	public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {

		ProductDTO productDTOsave = productService.save(productDTO);

		return new ResponseEntity<ProductDTO>(productDTOsave, HttpStatus.OK);
	}

	@GetMapping("/listOfProducts")
	public ResponseEntity<List<ProductDTO>> findAll() {

		List<ProductDTO> listProductDtos = productMapper.toLisProductDTOs(productService.findAll());
		return new ResponseEntity<List<ProductDTO>>(listProductDtos, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Integer id) {

		return new ResponseEntity<ProductDTO>(productService.updateProduct(productDTO, id), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
		productService.delete(id);
		return new ResponseEntity<String>("obrisan proizvod  za id" + id, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> findProductById(@PathVariable Integer id) {
		ProductDTO product = productMapper.toProductDTO(productService.findProductById(id));
		return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/insertProductWithPicture", method = RequestMethod.POST,  consumes = { "multipart/form-data" })
	public ResponseEntity<String> insertPicturesForProduct(@RequestParam Integer product_id, @RequestParam("files") MultipartFile [] files) throws IllegalStateException, IOException{
		
		picturesService.save(PictureCategory.PRODUCT, product_id, files);
		
		
		return new ResponseEntity<String>("Product is created.", HttpStatus.OK);
	}
	
	@GetMapping("/listOfPictures/product/{idProduct}")
	public ResponseEntity<List<String>> findAllPicturesForProduct(@PathVariable Integer idProduct) {
		List<String> list = picturesService.findPicturesForEntity(PictureCategory.PRODUCT, idProduct);
		
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);

	}

}

