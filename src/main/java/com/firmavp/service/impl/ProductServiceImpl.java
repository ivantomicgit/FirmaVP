package com.firmavp.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.ProductDTO;
import com.firmavp.entity.Product;

import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.ProductMapper;
import com.firmavp.repository.ProductRepository;

import com.firmavp.entity.Pictures;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.ProductMapper;
import com.firmavp.repository.ProductRepository;
import com.firmavp.repository.PicturesRepository;



import com.firmavp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final  ProductRepository productRepository;
	private final ProductMapper productMapper;


	private final PicturesRepository PicturesRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,PicturesRepository PicturesRepository) {
		super();
		this.productRepository = productRepository;
		this.productMapper=productMapper;
		this.PicturesRepository=PicturesRepository;

	}

	@Override
    @Transactional
	public ProductDTO save(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setShortDescription(productDTO.getShortDescription());
		product.setTitle(productDTO.getTitle());
		product.setCode(productDTO.getCode());
		productRepository.save(product);
		return productDTO ;
	}

	@Override
	@Transactional
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public ProductDTO updateProduct(ProductDTO productDTO, Integer id) {
		
		Product product= productRepository.findProductById(id);
		if(product == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no product for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();		
		}
		product.setId(id);
		product.setShortDescription(productDTO.getShortDescription());
		product.setTitle(productDTO.getTitle());
		product.setCode(productDTO.getCode());
		productRepository.save(product);
		
		return productMapper.toProductDTO(product);

}

	@Override
	@Transactional
	public void delete(Integer id) {
	Product product = productRepository.findProductById(id);
	if(product == null) {
		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no product for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();	
	}
	 productRepository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Product findProductById(Integer id) {
	
		return productRepository.findProductById(id);
	}

	@Override
	public ProductDTO findProductByDTOId(Integer id) {
		Product product = productRepository.findProductById(id);
		if(product == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("product does not exist for " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

		}
		
		return productMapper.toProductDTO(product);
	}
}
