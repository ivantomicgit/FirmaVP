package com.firmavp.controller.company;

import java.util.List;

import javax.persistence.EntityNotFoundException;

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

import com.firmavp.dto.CompanyDTO;

import com.firmavp.mapper.CompanyMapper;
import com.firmavp.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	private final CompanyService companyService;
	private final CompanyMapper companyMapper;

	@Autowired
	public CompanyController(CompanyMapper companyMapper, CompanyService companyService) {
		super();
		this.companyService = companyService;
		this.companyMapper = companyMapper;
	}

	@PostMapping("/create/{adressId}")
	public ResponseEntity<CompanyDTO> create(@RequestBody CompanyDTO companyDTO,@PathVariable Integer adressId) {
		CompanyDTO cDTO = companyService.save(companyDTO,adressId);
		return new ResponseEntity<CompanyDTO>(cDTO, HttpStatus.CREATED);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<CompanyDTO> read(@PathVariable Integer id) {
		
		CompanyDTO companyDTO = companyService.findCompany(id);
			
		return new ResponseEntity<CompanyDTO>( companyDTO , HttpStatus.OK);
	}

	@GetMapping("/readlist")
	public ResponseEntity<?> readList() {
		List<CompanyDTO> listCompanyDTO = companyMapper.toCompanyListDTO(companyService.findAll());

		return new ResponseEntity<List<CompanyDTO>>(listCompanyDTO, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CompanyDTO> update(@PathVariable Integer id, @RequestBody CompanyDTO companyDTO) {

		return new ResponseEntity<CompanyDTO>(companyService.update(id, companyDTO), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFirma(@PathVariable Integer id) {
		companyService.delete(id);
		return new ResponseEntity<String>("Company with id " + id + " is deleted", HttpStatus.OK);

	}
	

}
