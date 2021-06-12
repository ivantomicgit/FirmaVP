package com.firmavp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.firmavp.entity.Address;
import com.firmavp.entity.Role;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.RolesMapper;
import com.firmavp.repository.RolesRepository;
import com.firmavp.service.RolesService;
@Service
public class RolesServiceimpl  implements RolesService{
	
	private final RolesRepository rolesRepository;
	private final RolesMapper rolesMapper;
    
	@Autowired
	public RolesServiceimpl(RolesRepository rolesRepository, RolesMapper rolesMapper) {
		super();
		this.rolesRepository = rolesRepository;
		this.rolesMapper = rolesMapper;
	}

	@Override
	public Role save(Role role) {
		// TODO Auto-generated method stub
		return rolesRepository.save(role);
	}

	@Override
	public void delete(Integer id) {
		Role databaseRole = rolesRepository.findRoleById(id);
		if (databaseRole == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no role for id " + id)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		rolesRepository.deleteById(id);
	}		
	}


