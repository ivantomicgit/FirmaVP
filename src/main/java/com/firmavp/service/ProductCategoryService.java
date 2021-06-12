package com.firmavp.service;

import java.util.List;

import com.firmavp.dto.CompanyDTO;
import com.firmavp.dto.ProductCategoryDTO;
import com.firmavp.entity.ProductCategory;

public interface ProductCategoryService {

	ProductCategoryDTO save(ProductCategoryDTO productCategoryDTO);

	ProductCategoryDTO findProductCategory(Integer id);

	List<ProductCategory> findAll();

	void delete(Integer id);

	ProductCategoryDTO update(Integer id, ProductCategoryDTO productCategoryDTO);

	

}
