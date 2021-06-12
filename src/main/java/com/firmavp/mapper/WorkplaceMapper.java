package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.WorkplaceDTO;
import com.firmavp.entity.Workplace;

public interface WorkplaceMapper {
	
	List<Workplace>toWorkplaces(List<WorkplaceDTO> listDTO);
	Workplace toWorkplace(WorkplaceDTO dto);
	List<WorkplaceDTO>toWorkplaceDTOs(List<Workplace> list);
	WorkplaceDTO toWorkplaceDTO(Workplace Workplace);

}
