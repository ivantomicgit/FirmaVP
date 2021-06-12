package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.ProductCategoryDTO;
import com.firmavp.entity.ProductCategory;

public interface ProductCategoryMapper {

	ProductCategory toProductCategory(ProductCategoryDTO productCategoryDTO);

	ProductCategoryDTO toProductCategoryDTO(ProductCategory productCategory);

	List<ProductCategoryDTO> toProductCategoryListDTO(List<ProductCategory> findAll);

}
