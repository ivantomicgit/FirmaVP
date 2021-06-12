package com.firmavp.dto;

import com.firmavp.enums.DamageRepaired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDescriptionOfMaintenanceDTO {

	private int id;
	private String description;
	//private DamageRepaired isItDamaged;
}
