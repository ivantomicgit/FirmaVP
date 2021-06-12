package com.firmavp.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.entity.Staff;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.repository.StaffRepository;

@Service
public class TokenUserDetailsService implements UserDetailsService {
	private final StaffRepository staffRepository;
	
	

	@Autowired
	public TokenUserDetailsService(StaffRepository staffRepository) {
		super();
		this.staffRepository = staffRepository;
	}



	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Staff staff = staffRepository.findStaffByUsername(username);
		
		if (staff == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withMessage("").withError_code(HttpStatus.NOT_FOUND.name()).withDetail("No employee found.").build();
		}		
		return new User(staff.getUsername(), staff.getPassword(), staff.getAuthorities());
	}

}
