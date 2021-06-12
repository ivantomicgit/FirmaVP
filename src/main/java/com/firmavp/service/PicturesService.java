package com.firmavp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.firmavp.enums.PictureCategory;

public interface PicturesService {

	

	void save(PictureCategory category, Integer entity_id, MultipartFile[]  files) throws IllegalStateException, IOException;
	
	List<String> findPicturesForEntity(PictureCategory category, Integer entity_id );

	//List<Pictures> findAll();

	//PicturesDTO updatePictures(PicturesDTO PicturesDTO, Integer idProducta);

	//void delete(Integer id);


}
