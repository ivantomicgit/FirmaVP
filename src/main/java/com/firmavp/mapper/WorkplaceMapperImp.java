package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.WorkplaceDTO;
import com.firmavp.entity.Workplace;
@Component
public class WorkplaceMapperImp implements WorkplaceMapper {
	private final StaffMapper employeeMapper;
	
	

	@Autowired
	public WorkplaceMapperImp(StaffMapper employeeMapper) {
		super();
		this.employeeMapper = employeeMapper;
	}

	@Override
	public List<Workplace> toWorkplaces(List<WorkplaceDTO> listDTO) {
		List<Workplace> listWorkplace = new ArrayList<Workplace>();
		for (WorkplaceDTO workplaceDTO : listDTO) {
			Workplace workplace = new Workplace();
			workplace.setId(workplaceDTO.getId());
			workplace.setWorkplaceName(workplaceDTO.getWorkplaceName());
			//workplace.setListEmployees(workplaceDTO.getListEmployees());
			listWorkplace.add(workplace);
		}
		return listWorkplace;
	}

	@Override
	public Workplace toWorkplace(WorkplaceDTO workplaceDTO) {
		Workplace workplace = new Workplace();
		workplace.setId(workplaceDTO.getId());
		workplace.setWorkplaceName(workplaceDTO.getWorkplaceName());
		//workplace.setListEmployees(workplaceDTO.getListEmployees());
		return workplace;
	}

	@Override
	public List<WorkplaceDTO> toWorkplaceDTOs(List<Workplace> list) {
		List<WorkplaceDTO> listDTO = new ArrayList<WorkplaceDTO>();
		for (Workplace workplace : list) {
			WorkplaceDTO dto = new WorkplaceDTO();
			dto.setId(workplace.getId());
			dto.setWorkplaceName(workplace.getWorkplaceName());
			//dto.setListEmployees(workplace.getListEmployees());;
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public WorkplaceDTO toWorkplaceDTO(Workplace workplace) {
		WorkplaceDTO dto = new WorkplaceDTO();
		dto.setId(workplace.getId());
		dto.setWorkplaceName(workplace.getWorkplaceName());
		//dto.setListEmployees(workplace.getListEmployees());
		return dto;
	}

	

	

}
