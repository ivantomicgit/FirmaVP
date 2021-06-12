package com.firmavp.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;





@Getter
@Setter
public class ProductDTO {
	private int id;
	private String title;
	private String code;
	private String shortDescription;
	private List<PicturesDTO>listPicture;

	
	

	

}
