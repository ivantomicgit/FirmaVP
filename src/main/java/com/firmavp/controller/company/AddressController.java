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

import com.firmavp.dto.AddressDTO;
import com.firmavp.entity.Address;
import com.firmavp.mapper.AddressMapper;
import com.firmavp.service.AddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "AddressController" ,description="Address controller for company")
@RestController
@RequestMapping("/api/address")

public class AddressController {

	private final AddressService addresssService;
	private final AddressMapper addressMapper;

	@Autowired
	public AddressController(AddressService adresaService, AddressMapper addressMapper) {
		super();
		this.addresssService = adresaService;
		this.addressMapper = addressMapper;
	}
	@ApiOperation(value = "Create address dejan dkdkdk")
	@PostMapping("/create")
	public ResponseEntity<Address> create(@RequestBody Address address) {

		return new ResponseEntity<Address>(addresssService.save(address), HttpStatus.CREATED);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<AddressDTO> readAdresa(@PathVariable Integer id) {
		AddressDTO addressDTO = addressMapper.toAddressDTO(addresssService.findAddressById(id));
		return new ResponseEntity<AddressDTO>(addressDTO, HttpStatus.OK);
	}

	@GetMapping("/readlist")
	public ResponseEntity<?> readListFirma() {
		List<AddressDTO> listAddressDTO = addressMapper.toListAddressDTO(addresssService.findAll());

		return new ResponseEntity<List<AddressDTO>>(listAddressDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<AddressDTO> update(@PathVariable Integer id, @RequestBody AddressDTO addressDTO) {
			
		return new ResponseEntity<AddressDTO>(addresssService.update(id, addressDTO), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFirma(@PathVariable Integer id) {
		addresssService.delete(id);
		return new ResponseEntity<String>("Address for id " + id + "is deleted", HttpStatus.OK);

	}
}
