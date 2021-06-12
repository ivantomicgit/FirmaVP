package com.firmavp.controller.employee;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firmavp.dto.StaffDTO;
import com.firmavp.dto.WorkplaceDTO;
import com.firmavp.fasada.WorkplaceFacade;

@RestController
@RequestMapping("/api/workplace")
@CrossOrigin
public class WorkplaceController {
	private final WorkplaceFacade workplaceFacade;

	
	@Autowired
	public WorkplaceController(WorkplaceFacade workplaceFacade) {
		super();
		this.workplaceFacade = workplaceFacade;
	}
	
	@GetMapping("/listOfWorkplaces")
	public ResponseEntity<List<WorkplaceDTO>>returnListOfAllWorkplaces(){
		List<WorkplaceDTO> workplaces = workplaceFacade.findAll();
		return new ResponseEntity<List<WorkplaceDTO>>(workplaces, HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<WorkplaceDTO>insertNewWorkplace(@Valid @RequestBody WorkplaceDTO workplaceDTO){
		WorkplaceDTO dto = workplaceFacade.save(workplaceDTO);
		return new ResponseEntity<WorkplaceDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WorkplaceDTO>returnsWorkplaceDTOByGivenId(@PathVariable Integer id){
		WorkplaceDTO dto = workplaceFacade.findWorkplaceById(id);
		return new ResponseEntity<WorkplaceDTO>(dto, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<WorkplaceDTO>updateWorkplace(@Valid @RequestBody WorkplaceDTO workplaceDTO){
		WorkplaceDTO dto = workplaceFacade.save(workplaceDTO);
		return new ResponseEntity<WorkplaceDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/search/listOfEmployees/byWorkplace")

	public ResponseEntity<List<StaffDTO>> returnsAListOfEmployeesForThatWorkplace(

			@RequestParam Optional<String> workplaceName,

			@RequestParam Optional<Integer> page,

			@RequestParam Optional<String> sorting

	) {

		return new ResponseEntity<List<StaffDTO>>(workplaceFacade.findStaffByWorkplace(workplaceName, page, sorting),
				HttpStatus.OK);

	}
	 
	
	


	
	

}
