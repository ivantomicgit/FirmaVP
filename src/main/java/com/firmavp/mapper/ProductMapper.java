package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.ProductDTO;
import com.firmavp.entity.Product;

public interface ProductMapper {
	
	ProductDTO toProductDTO(Product product);

	Product toProduct(ProductDTO productDTO);

	List<ProductDTO> toLisProductDTOs(List<Product> listProduct);
	
	List<Product> toListProducts(List<ProductDTO> listProductsDTO);
}
