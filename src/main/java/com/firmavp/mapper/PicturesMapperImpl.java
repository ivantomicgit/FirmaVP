package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.PicturesDTO;
import com.firmavp.entity.Pictures;

@Component
public class PicturesMapperImpl  implements PicturesMapper{
	@Autowired
	private  ProductMapper productMapper;
	
	
	

	public ProductMapper getProductMapper() {
		return productMapper;
	}

	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	@Override
	public PicturesDTO toPicturesDTO(Pictures pictures) {
		PicturesDTO picturesDTO = new PicturesDTO();
		picturesDTO.setId(pictures.getId());
		picturesDTO.setDescription(pictures.getDescription());
		picturesDTO.setUrlPictures(pictures.getUrlPictures());
		//picturesDTO.setProduct_id(productMapper.toProductDTO(pictures.getProduct()));
		return picturesDTO;
	}

	@Override
	public Pictures toPictures(PicturesDTO picturesDTO) {
		Pictures pictures = new Pictures();
		pictures.setId(picturesDTO.getId());
		pictures.setDescription(picturesDTO.getDescription());
		pictures.setUrlPictures(picturesDTO.getUrlPictures());
		//pictures.setProduct(productMapper.toProduct(picturesDTO.getProduct_id()));
		return pictures;
	}

	@Override
	public List<PicturesDTO> toPicturesDTOs(List<Pictures> listPictures) {
		List<PicturesDTO>listPicturesDTOs= new ArrayList<PicturesDTO>();
		for(Pictures pictures :listPictures) {
			PicturesDTO picturesDTO = new PicturesDTO();
			picturesDTO.setId(pictures.getId());
			picturesDTO.setDescription(pictures.getDescription());
			picturesDTO.setUrlPictures(pictures.getUrlPictures());
		//	picturesDTO.setProduct_id(productMapper.toProductDTO(pictures.getProduct()));
			listPicturesDTOs.add(picturesDTO);
		}
		return listPicturesDTOs;
	}

	@Override
	public List<Pictures> toPictures(List<PicturesDTO> listPicturesDTOs) {
		List<Pictures>listPictures=new ArrayList<Pictures>();
		for (PicturesDTO picturesDTO : listPicturesDTOs) {
			Pictures pictures = new Pictures();
			pictures.setId(picturesDTO.getId());
			pictures.setDescription(picturesDTO.getDescription());
			pictures.setUrlPictures(picturesDTO.getUrlPictures());
			//pictures.setProduct(productMapper.toProduct(picturesDTO.getProduct_id()));
			listPictures.add(pictures);
		}
		return listPictures;
	}

}
