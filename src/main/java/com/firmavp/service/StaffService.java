package com.firmavp.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.firmavp.dto.StaffDTO;

import com.firmavp.dto.UserDTO;

import com.firmavp.entity.Role;

import com.firmavp.entity.Staff;

public interface StaffService {


	Staff save(Staff staff, Integer idCompany, Integer idPlace, Integer idWorkplace);


	void delete(Integer id);

	Staff update(Integer id, Staff staff);

	List<StaffDTO> returnAllStaff(Integer id);


	StaffDTO save(Staff staff);


	void saveUser(UserDTO userDTO);

	StaffDTO save(Integer idRoles, Set<Role> roles);



}
