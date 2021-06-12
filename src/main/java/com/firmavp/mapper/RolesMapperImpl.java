package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.firmavp.dto.RolesDTO;
import com.firmavp.entity.Role;

@Component
public class RolesMapperImpl implements RolesMapper {

	@Override
	public RolesDTO toRolesDTO(Role role) {
		RolesDTO rolesDTO = new RolesDTO();
		rolesDTO.setRoleName(role.getRoleName());
		return rolesDTO;
	}

	@Override
	public Role toRole(RolesDTO rolesDTO) {
		Role role = new Role();
		role.setRoleName(rolesDTO.getRoleName());
		return role;
	}

	@Override
	public List<RolesDTO> toRolesDTOs(List<Role> lisRoles) {
		List<RolesDTO>rolesDTOs = new ArrayList<RolesDTO>();
		for(Role r : lisRoles) {
			RolesDTO  rolesDTO = new RolesDTO();	
			rolesDTO.setRoleName(r.getRoleName());
			rolesDTOs.add(rolesDTO);
		   }
		return rolesDTOs;
	}

	@Override
	public List<Role> toRoles(List<RolesDTO> rolesDTOs) {
		List<Role>roles = new ArrayList<Role>();
		for(RolesDTO r : rolesDTOs) {
			
		
		Role role = new Role();
		role.setRoleName(r.getRoleName());
		roles.add(role);
		
		
	}
		return roles;
	}

}
