package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.PicturesDTO;
import com.firmavp.dto.ProductDTO;
import com.firmavp.entity.Pictures;
import com.firmavp.entity.Product;



@Component
public class ProductMapperImpl implements ProductMapper {



	private final PicturesMapper picturesMapper;
	@Autowired
	public ProductMapperImpl(PicturesMapper picturesMapper) {
		super();
		this.picturesMapper = picturesMapper;

	}

	@Override
	public ProductDTO toProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setShortDescription(product.getShortDescription());
		productDTO.setTitle(product.getTitle());
		productDTO.setCode(product.getCode());


		/*
		 * if (product.getListPictures()==null) { productDTO.setListPicture(new
		 * ArrayList<PicturesDTO>()); }else {
		 * productDTO.setListPicture(picturesMapper.toPicturesDTOs(product.
		 * getListPictures()));
		 * 
		 * }
		 */

		return productDTO;
	}

	@Override
	public Product toProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setShortDescription(productDTO.getShortDescription());
		product.setTitle(productDTO.getTitle());
		product.setCode(productDTO.getCode());


		/*
		 * if (productDTO.getListPicture() == null) { product.setListPictures(new
		 * ArrayList<Pictures>()); } else {
		 * product.setListPictures(picturesMapper.toPictures(productDTO.getListPicture()
		 * )); }
		 */
		

		return product;
	}

	@Override
	public List<ProductDTO> toLisProductDTOs(List<Product> listProduct) {
		List<ProductDTO>listaProductDtos = new ArrayList<ProductDTO>();
		for(Product p : listProduct) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(p.getId());
			productDTO.setShortDescription(p.getShortDescription());
			productDTO.setTitle(p.getTitle());
			productDTO.setCode(p.getCode());


			/*
			 * if (p.getListPictures()==null) { productDTO.setListPicture(new
			 * ArrayList<PicturesDTO>()); }else {
			 * productDTO.setListPicture(picturesMapper.toPicturesDTOs(p.getListPictures()))
			 * ;
			 * 
			 * }
			 */

			listaProductDtos.add(productDTO);
		}
		return listaProductDtos;
	}


	@Override
	public List<Product> toListProducts(List<ProductDTO> listProductsDTO) {
		List<Product> listOfProducts = new ArrayList<Product>();
		for(ProductDTO pDTO : listProductsDTO) {
			Product product = new Product();
			product.setId(pDTO.getId());
			product.setTitle(pDTO.getTitle());
			product.setShortDescription(pDTO.getShortDescription());
			product.setCode(pDTO.getCode());

			/*
			 * if (pDTO.getListPicture() == null) { product.setListPictures(new
			 * ArrayList<Pictures>()); } else {
			 * product.setListPictures(picturesMapper.toPictures(pDTO.getListPicture())); }
			 */
		
			listOfProducts.add(product);			
		}
		
		return listOfProducts;
	}

}
