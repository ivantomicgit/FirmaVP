package com.firmavp.dto;


import java.util.Set;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DriversDTO {
	private int id;
	private String nationalIdentificationNumber;
	private String driverLicenceNumber;
	private String licenceCategories;
	//private Set<VehicleDTO>vehiclesDTO;
	private StaffDTO staffDTO;
	

	
}
