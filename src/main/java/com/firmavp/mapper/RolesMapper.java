package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.RolesDTO;
import com.firmavp.entity.Role;

public interface RolesMapper {

	
	RolesDTO toRolesDTO(Role role);
	Role toRole(RolesDTO rolesDTO);
	List<RolesDTO>toRolesDTOs(List<Role>lisRoles);
	List<Role>toRoles(List<RolesDTO>rolesDTOs);
}
