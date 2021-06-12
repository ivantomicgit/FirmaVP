package com.firmavp.service;

import java.util.List;


import com.firmavp.dto.ProductDTO;
import com.firmavp.entity.Product;

public interface ProductService {

	ProductDTO save(ProductDTO proizvodDTO);

	List<Product> findAll();

	ProductDTO updateProduct(ProductDTO proizvodDTO, Integer id);

	void delete(Integer id);

	Product findProductById(Integer id);

	ProductDTO findProductByDTOId(Integer id);



}
