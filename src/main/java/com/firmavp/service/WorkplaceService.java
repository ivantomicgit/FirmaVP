package com.firmavp.service;

import java.util.List;
import java.util.Optional;

import com.firmavp.entity.Staff;
import com.firmavp.entity.Workplace;

public interface WorkplaceService {

	List<Workplace> findAll();

	Workplace save(Workplace workplace);

	Workplace findWorkplaceById(Integer id);

	List<Staff> findStaffByWorkplace(Optional<String> workplaceName, Optional<Integer> page,
			Optional<String> sorting);

	

}
