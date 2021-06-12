package com.firmavp.fasada;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.firmavp.dto.StaffDTO;
import com.firmavp.dto.WorkplaceDTO;
import com.firmavp.entity.Staff;
import com.firmavp.entity.Workplace;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.StaffMapper;
import com.firmavp.mapper.WorkplaceMapper;
import com.firmavp.service.WorkplaceService;

@Component
public class WorkplaceFacadeImpl implements WorkplaceFacade {
	private final WorkplaceService workplaceService;
	private final WorkplaceMapper workplaceMapper;
	private final StaffMapper staffMapper;
	
	
	@Autowired
	public WorkplaceFacadeImpl(WorkplaceService workplaceService, WorkplaceMapper workplaceMapper, StaffMapper staffMapper) {
		super();
		this.workplaceService = workplaceService;
		this.workplaceMapper = workplaceMapper;
		this.staffMapper = staffMapper;
	}



	@Override
	public List<WorkplaceDTO> findAll() {
		List<Workplace> list = null;
		try {
			list = workplaceService.findAll();
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withMessage("").withDetail("No workplaces found.").build();
		}
		List<WorkplaceDTO> listDTO = workplaceMapper.toWorkplaceDTOs(list);
		return listDTO;
	}



	@Override
	public WorkplaceDTO save(@Valid WorkplaceDTO workplaceDTO) {
		Workplace workplace = workplaceMapper.toWorkplace(workplaceDTO);
		workplace = workplaceService.save(workplace);
		return workplaceMapper.toWorkplaceDTO(workplace);
	}



	@Override
	public WorkplaceDTO findWorkplaceById(Integer id) {
		Workplace workplace = null;
		try {
			workplace = workplaceService.findWorkplaceById(id);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withMessage("").withDetail("Workplace with id" + id + "not found.").build();
		}
		return workplaceMapper.toWorkplaceDTO(workplace);
	}



	@Override
	public List<StaffDTO> findStaffByWorkplace(Optional<String> workplaceName, Optional<Integer> page,
			Optional<String> sorting) {
		
		List<Staff> listEmployees = workplaceService.findStaffByWorkplace(workplaceName, page, sorting);
		List<StaffDTO> listEmployeesDTO= new ArrayList<StaffDTO>();
		for (Staff staff : listEmployees) {
			listEmployeesDTO.add(staffMapper.toStaffDTO(staff));
		}
		return listEmployeesDTO;
	}




}
