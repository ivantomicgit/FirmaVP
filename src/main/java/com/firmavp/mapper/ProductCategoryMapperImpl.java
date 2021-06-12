package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.CompanyDTO;
import com.firmavp.dto.ProductCategoryDTO;
import com.firmavp.entity.Company;
import com.firmavp.entity.ProductCategory;

@Component
public class ProductCategoryMapperImpl implements ProductCategoryMapper {

	//private final ProizvodMapper productMapper;
	private final ProductMapper productMapper;

	@Autowired
	public ProductCategoryMapperImpl(ProductMapper proizvodMapper) {
		super();
		this.productMapper = proizvodMapper;
	}

	@Override
	public ProductCategory toProductCategory(ProductCategoryDTO productCategoryDTO) {	
		ProductCategory productCategory = new ProductCategory();		
		productCategory.setId(productCategoryDTO.getId());
		productCategory.setCategoryName(productCategoryDTO.getCategoryName());
		productCategory.setListProducts(productMapper.toListProducts(productCategoryDTO.getListProductsDTO()));
		
		return productCategory;
	}

	@Override
	public ProductCategoryDTO toProductCategoryDTO(ProductCategory productCategory) {
		ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
		categoryDTO.setId(productCategory.getId());
		categoryDTO.setCategoryName(productCategory.getCategoryName());
		categoryDTO.setListProductsDTO(productMapper.toLisProductDTOs(productCategory.getListProducts()));
		return categoryDTO;
	}

	@Override
	public List<ProductCategoryDTO> toProductCategoryListDTO(List<ProductCategory> listProductCategory) {
		 List<ProductCategoryDTO> listProductCategoryDTO = new ArrayList<ProductCategoryDTO>();
		 for(ProductCategory pc : listProductCategory) {
			 ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
			 productCategoryDTO.setId(pc.getId());
			 productCategoryDTO.setCategoryName(pc.getCategoryName());
			 productCategoryDTO.setListProductsDTO(productMapper.toLisProductDTOs(pc.getListProducts()));
			
			 listProductCategoryDTO.add(productCategoryDTO);
		 }
		return listProductCategoryDTO;
	}

}
