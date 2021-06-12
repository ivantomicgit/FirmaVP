package com.firmavp.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.entity.Staff;
import com.firmavp.entity.Workplace;
import com.firmavp.repository.StaffRepository;
import com.firmavp.repository.WorkplaceRepository;
import com.firmavp.service.WorkplaceService;

@Service
public class WorkplaceServiceImpl implements WorkplaceService {
	
	private final WorkplaceRepository workplaceRepository;	
	private final StaffRepository staffRepository;
	
	@Autowired
	public WorkplaceServiceImpl(WorkplaceRepository workplaceRepository, StaffRepository staffRepository ) {
		super();
		this.workplaceRepository = workplaceRepository;
		this.staffRepository = staffRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Workplace> findAll() {
		
		return workplaceRepository.findAll();
	}
	@Override
	@Transactional
	public Workplace save(Workplace workplace) {
	
		return workplaceRepository.save(workplace);
	}
	@Override
	@Transactional(readOnly = true)
	public Workplace findWorkplaceById(Integer id) {

	return workplaceRepository.findWorkplaceById(id);
	}
	

	@Override
	public List<Staff> findStaffByWorkplace(Optional<String> workplaceName, Optional<Integer> page,
			Optional<String> sorting) {
		List<Staff> listEmployees =  staffRepository.findStaffByWorkplace(workplaceName.orElse(""), PageRequest.of(page.orElse(0),10, Sort.by(sorting.orElse("id")).ascending()));
		//listEmployees = workplaceRepository.findStaffByWorkplace(workplaceName.orElse(""), PageRequest.of(page.orElse(0),10, Sort.by(sorting.orElse("id")).ascending()));
		
		return listEmployees;
	}
	
}
