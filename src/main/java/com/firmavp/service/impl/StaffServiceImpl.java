package com.firmavp.service.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.firmavp.dto.StaffDTO;
import com.firmavp.dto.UserDTO;
import com.firmavp.entity.Role;
import com.firmavp.entity.Staff;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.StaffMapper;
import com.firmavp.repository.RolesRepository;
import com.firmavp.repository.StaffRepository;
import com.firmavp.service.StaffService;
@Service
public class StaffServiceImpl implements StaffService{
	private final StaffRepository staffRepository;
	private final StaffMapper staffMapper;
	private final RolesRepository rolesRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
    @Autowired
	public StaffServiceImpl(StaffRepository staffRepository, StaffMapper staffMapper,RolesRepository rolesRepository) {
		super();
		this.staffRepository = staffRepository;
		this.staffMapper =staffMapper;
		this.rolesRepository=rolesRepository;
	}



	@Override
	@Transactional
	public Staff save(Staff zaposleni, Integer idFirma, Integer idMesto, Integer idRadnoMesto) {
		return staffRepository.save(zaposleni);
	}

	
	@Override
	@Transactional
	public void delete(Integer id) {
		
			Staff staff = staffRepository.findStaffById(id);
			if(staff == null) {

	    		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no staff for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

			}
			 staffRepository.delete(staff);
	}
	
	@Override
	@Transactional
	public Staff update(Integer id, Staff staff) {
		 staff.setId(id);	
			 
		 Staff saveStaff = staffRepository.findStaffById(id);
		 if(saveStaff == null) {

	    		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no staff for id " +id).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

		}		
		saveStaff= staffRepository.save(staff);
		 return saveStaff;
	}


	@Override
	@Transactional
	public List<StaffDTO> returnAllStaff(Integer id) {
		// TODO Auto-generated method stub
		List<Staff> staff = staffRepository.findAll();
		staffMapper.readDataAndCreateMap(staff);
		staffMapper.buildHierarchyTree(staffMapper.getRoot());
		
		return staffMapper.getEmployee();
	}





	@Override
	@Transactional
	public StaffDTO save(Staff staff) {
		staff= staffRepository.save(staff);
		return staffMapper.toStaffDTO(staff);
	}



	@Override

	@Transactional
	public void saveUser(UserDTO userDTO) {
		Staff staff = new Staff();
		staff.setUsername(userDTO.getUsername());
		staff.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
		staffRepository.save(staff);
		
	}



	public StaffDTO save(Integer idStaff, Set<Role> roles) {
			
		 Staff staff = staffRepository.findStaffById(idStaff);
		 if(staff == null) {

	    		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no staff for id " +idStaff).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
	
	}
		 for(Role role : roles) {
			 staff.setRoles(roles);
			 staffRepository.save(staff);

		 }
			return  null;



	

	
		
	}
}


