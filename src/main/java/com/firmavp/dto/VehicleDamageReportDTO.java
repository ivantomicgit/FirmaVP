package com.firmavp.dto;

import java.time.LocalDateTime;

import com.firmavp.enums.DamageRepaired;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VehicleDamageReportDTO {
	private int id;
	private String description;
	private LocalDateTime timeOfTheEvent;
	//private VehicleDTO idVehicle;
	//private VehicleMaintenanceCategoryDTO maintenanceCategory;
	
	private DamageRepaired damageRepaired;
	
}
