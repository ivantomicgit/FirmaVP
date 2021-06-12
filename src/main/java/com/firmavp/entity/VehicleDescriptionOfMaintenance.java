package com.firmavp.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.firmavp.enums.DamageRepaired;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VehicleDescriptionOfMaintenance extends BaseEntity {
	
	private String description;
//	@Enumerated(EnumType.STRING) 
//	private DamageRepaired isDamageRepaired;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maintenance_category")	
	private VehicleMaintenanceCategory maintenance_category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	
}
