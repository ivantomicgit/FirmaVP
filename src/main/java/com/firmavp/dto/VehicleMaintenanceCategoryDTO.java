package com.firmavp.dto;

import java.util.ArrayList;
import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleMaintenanceCategoryDTO {

	private int id;
	private String categoryName;
	private List<VehicleDescriptionOfMaintenanceDTO> listVehicleMaintenanceDescriptions = new ArrayList<VehicleDescriptionOfMaintenanceDTO>();
	
}
