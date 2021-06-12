package com.firmavp.fasada;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.firmavp.dto.StaffDTO;
import com.firmavp.dto.WorkplaceDTO;


public interface WorkplaceFacade {

	List<WorkplaceDTO> findAll();

	WorkplaceDTO save(@Valid WorkplaceDTO radnoMestoDTO);

	WorkplaceDTO findWorkplaceById(Integer id);

	List<StaffDTO> findStaffByWorkplace(Optional<String> workplaceName, Optional<Integer> page,
			Optional<String> sorting);



}
