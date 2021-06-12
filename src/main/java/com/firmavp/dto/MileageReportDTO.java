package com.firmavp.dto;

import java.time.LocalDate;


import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class MileageReportDTO {
	private int id;
	private LocalDate dateOfEntry;
	private Double numberOfKilometers;
	private Double numberOfHours;
	private VehicleDTO vehicle_id;
	private DriversDTO drivers_id;
	
	
	
	
	

}
