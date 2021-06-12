package com.firmavp.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.firmavp.dto.PicturesDTO;
import com.firmavp.dto.ProductDTO;
import com.firmavp.entity.Product;
import com.firmavp.enums.PictureCategory;
import com.firmavp.entity.Pictures;
import com.firmavp.mapper.PicturesMapper;
import com.firmavp.repository.ProductRepository;
import com.firmavp.repository.PicturesRepository;
import com.firmavp.service.PicturesService;

@Service
public class PicturesServiceImpl implements PicturesService {
	private final PicturesRepository picturesRepository;
	private final PicturesMapper PicturesMapper;
	private final ProductRepository productRepository;

	@Autowired
	public PicturesServiceImpl(PicturesRepository picturesRepository, PicturesMapper PicturesMapper,
			ProductRepository productRepository) {
		super();
		this.picturesRepository = picturesRepository;
		this.PicturesMapper = PicturesMapper;
		this.productRepository = productRepository;
	}

	@Override
	@Transactional
	public void save(PictureCategory category, Integer id, MultipartFile [] files) throws IllegalStateException, IOException {
		
		String uploadDirectory = directoryPath() + "\\src\\main\\resources\\static\\images\\"+ category+"\\";
		File f = new File(uploadDirectory);
		if (!f.exists()) {
			f.mkdir();
		}
		
		uploadDirectory = directoryPath() + "\\src\\main\\resources\\static\\images\\"+ category+"\\" + id+ "\\";
		f = new File(uploadDirectory);
		if (!f.exists()) {
			f.mkdir();
		}
		
		for (MultipartFile multipartFile : files) {
			Pictures pictures = new Pictures();
			pictures.setCategory(category);
			pictures.setEntity_id(id);
			pictures.setDescription(multipartFile.getOriginalFilename());
			pictures = picturesRepository.save(pictures);
			String fileName = Integer.toString(pictures.getId());
			
			String url = uploadDirectory + fileName;
			pictures.setUrlPictures(url);
			picturesRepository.save(pictures);
			url = url+".jpg";
			Path path = Paths.get(url);
			multipartFile.transferTo(path);
			
		}

	}

	@Override
	@Transactional
	public List<String> findPicturesForEntity(PictureCategory category,Integer entity_id) {
		
		return picturesRepository.findPicturesByEntityId(category.ordinal(), entity_id);
	}

	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<Pictures> findAll() {
	 * 
	 * return picturesRepository.findAll(); }
	 */

	/*
	 * @Override
	 * 
	 * @Transactional public PicturesDTO updatePictures(PicturesDTO PicturesDTO,
	 * Integer idProducta) { Product product =
	 * productRepository.findProductById(idProducta); if (product == null) { throw
	 * new EntityNotFoundException("ne postoji product za id" + idProducta);
	 * 
	 * } Pictures Pictures = PicturesMapper.toPictures(PicturesDTO);
	 * 
	 * try { Pictures.setProduct(product); picturesRepository.save(Pictures); }
	 * catch (Exception e) {
	 * 
	 * }
	 * 
	 * return PicturesMapper.toPicturesDTO(Pictures); }
	 */

	/*
	 * @Override
	 * 
	 * @Transactional public void delete(Integer id) { Pictures slika =
	 * picturesRepository.findPicturesById(id); if (slika == null) { throw new
	 * EntityNotFoundException("ne postoji slika za id" + id); }
	 * picturesRepository.deleteById(id);
	 * 
	 * }
	 */
	
	

	private String directoryPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	

}
