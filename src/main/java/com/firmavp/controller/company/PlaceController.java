package com.firmavp.controller.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.firmavp.dto.PlaceDTO;
import com.firmavp.entity.Company;
import com.firmavp.entity.Place;
import com.firmavp.mapper.PlaceMapper;
import com.firmavp.service.PlaceService;

@RestController
@RequestMapping("/api/place")
public class PlaceController {

	private final PlaceService placeService;
	private final PlaceMapper placeMapper;

	@Autowired
	public PlaceController(PlaceMapper placeMapper, PlaceService placeService) {
		super();
		this.placeService = placeService;
		this.placeMapper = placeMapper;
	}

	@PostMapping("/create/{idCompany}")
	public ResponseEntity<?> createMesto(@RequestBody PlaceDTO mestoDTO, @PathVariable Integer idCompany) {

		PlaceDTO placeDTO1 = placeService.save(mestoDTO, idCompany);

		return new ResponseEntity<PlaceDTO>(placeDTO1, HttpStatus.OK);

	}

	@GetMapping("read/{id}")
	public ResponseEntity<PlaceDTO> readeMesto(@PathVariable Integer id) {
		PlaceDTO placeDTO = placeMapper.toPlaceDTO(placeService.findPlace(id));
		return new ResponseEntity<PlaceDTO>(placeDTO, HttpStatus.OK);
	}

	@GetMapping("/listPlaces")
	public ResponseEntity<List<PlaceDTO>> findAll() {
		List<PlaceDTO> listPlacesDTO = placeMapper.toListPlacesDTO(placeService.findAll());

		return new ResponseEntity<List<PlaceDTO>>(listPlacesDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{idCompany}")
	public ResponseEntity<PlaceDTO> updateMesto(@RequestBody PlaceDTO placeDTO, @PathVariable Integer idCompany) {

		return new ResponseEntity<PlaceDTO>(placeService.updateMesto(placeDTO, idCompany), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMesto(@PathVariable Integer id) {
		placeService.delete(id);
		return new ResponseEntity<String>("Place with id " + id + " is deleted", HttpStatus.OK);

	}

}
