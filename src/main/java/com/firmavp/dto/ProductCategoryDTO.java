package com.firmavp.dto;


import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductCategoryDTO {

	private int id;
	private String categoryName;	
	private List<ProductDTO>listProductsDTO;
	
	
	
	
	
	
}
