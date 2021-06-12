package com.firmavp.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firmavp.entity.Address;
import com.firmavp.entity.Role;
import com.firmavp.mapper.RolesMapper;
import com.firmavp.service.RolesService;

@RestController
@RequestMapping("/api/roles/")
public class RolesController {
	
	private final RolesService rolesService;
	private final RolesMapper rolesMapper;
	@Autowired
	public RolesController(RolesService rolesService, RolesMapper rolesMapper) {
		super();
		this.rolesService = rolesService;
		this.rolesMapper = rolesMapper;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Role> create(@RequestBody Role role) {

		return new ResponseEntity<Role>(rolesService.save(role), HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable Integer id) {
		rolesService.delete(id);
		return new ResponseEntity<String>("Role for id " + id + "is deleted", HttpStatus.OK);

	}

}
