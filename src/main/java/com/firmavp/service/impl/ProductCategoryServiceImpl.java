package com.firmavp.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.ProductCategoryDTO;

import com.firmavp.entity.Product;
import com.firmavp.entity.ProductCategory;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.ProductCategoryMapper;
import com.firmavp.repository.ProductCategoryRepository;
import com.firmavp.repository.ProductRepository;

import com.firmavp.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	private final ProductCategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final ProductCategoryMapper categoryMapper;

	@Autowired
	public ProductCategoryServiceImpl(ProductCategoryRepository categoryRepository,
			ProductCategoryMapper categoryMapper, ProductRepository proizvodRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
		this.productRepository = proizvodRepository;
	}

	@Override
	@Transactional
	public ProductCategoryDTO save(ProductCategoryDTO productCategoryDTO) {
		ProductCategory productCategory = categoryMapper.toProductCategory(productCategoryDTO);

		List<Product> listProizvod = productCategory.getListProducts();
		for (Product p : listProizvod) {

			p.setProductCategory(productCategory);

		}
		productRepository.saveAll(listProizvod);

		return categoryMapper.toProductCategoryDTO(categoryRepository.save(productCategory));
	}

	@Override
	@Transactional(readOnly = true)
	public ProductCategoryDTO findProductCategory(Integer id) {
		ProductCategory productCategory = categoryRepository.findProductCategoryById(id);

		if (productCategory == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("category does not exist for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}

		return categoryMapper.toProductCategoryDTO(productCategory);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductCategory> findAll() {

		List<ProductCategory> listProductCategory = categoryRepository.findAll();
		if (listProductCategory == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("There isn't any category " ).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}

		return listProductCategory;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		ProductCategory productCategory = categoryRepository.findProductCategoryById(id);

		if (productCategory == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("category does not exist for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		categoryRepository.delete(productCategory);
	}

	@Override
	@Transactional
	public ProductCategoryDTO update(Integer id, ProductCategoryDTO productCategoryDTO) {
		ProductCategory productCategory = categoryMapper.toProductCategory(productCategoryDTO);

		productCategory.setId(id);
		ProductCategory productCategoryFromDatabase = categoryRepository.findProductCategoryById(id);
		if (productCategoryFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("category does not exist for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		categoryRepository.save(productCategory);

		return categoryMapper.toProductCategoryDTO(productCategory);
	}

}
