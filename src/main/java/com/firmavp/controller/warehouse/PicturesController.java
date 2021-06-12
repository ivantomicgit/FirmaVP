package com.firmavp.controller.warehouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firmavp.dto.PicturesDTO;

import com.firmavp.mapper.PicturesMapper;
import com.firmavp.service.PicturesService;

@RestController
@RequestMapping("api/pictures/")
@CrossOrigin
public class PicturesController {

	private final PicturesService picturesService;
	private final PicturesMapper picturesMapper;

	@Autowired
	public PicturesController(PicturesService picturesService, PicturesMapper picturesMapper) {
		super();
		this.picturesService = picturesService;
		this.picturesMapper = picturesMapper;
	}

	/*
	 * @PostMapping("/insert/{idProduct}") public ResponseEntity<PicturesDTO>
	 * SavePictures(@PathVariable Integer idProduct,
	 * 
	 * @RequestBody PicturesDTO PicturesDTO) { PicturesDTO PicturesDTO2 =
	 * PicturesDTO;
	 * 
	 * return new ResponseEntity<PicturesDTO>(PicturesDTO2, HttpStatus.OK); }
	 */

	/*
	 * @GetMapping("/listaSlika") public ResponseEntity<List<PicturesDTO>>findAll(){
	 * 
	 * List<PicturesDTO>liPicturesDTOs =
	 * picturesMapper.toPicturesDTOs(picturesService.findAll()); return new
	 * ResponseEntity<List<PicturesDTO>>(liPicturesDTOs,HttpStatus.OK); }
	 * 
	 * @PutMapping("/update/{idProduct}") public ResponseEntity<PicturesDTO>
	 * updatePictures(@RequestBody PicturesDTO PicturesDTO, @PathVariable Integer
	 * idProduct) {
	 * 
	 * return new
	 * ResponseEntity<PicturesDTO>(picturesService.updatePictures(PicturesDTO,
	 * idProduct), HttpStatus.OK); }
	 * 
	 * 
	 * @DeleteMapping("/delete/{id}") public ResponseEntity<String>
	 * deletePictures(@PathVariable Integer id) { picturesService.delete(id); return
	 * new ResponseEntity<String>("obrisana slika  za id" + id, HttpStatus.OK);
	 * 
	 * }
	 */
}
