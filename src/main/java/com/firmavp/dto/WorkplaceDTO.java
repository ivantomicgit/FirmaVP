package com.firmavp.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class WorkplaceDTO {
	private Integer id;
	private String workplaceName;
	private List<StaffDTO>listEmployeesDTO;


	
}
