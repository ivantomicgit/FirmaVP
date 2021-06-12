package com.firmavp.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.firmavp.enums.DamageRepaired;

@Entity
@Getter
@Setter
public class VehicleDamageReport extends BaseEntity{
	private String description;
	private LocalDateTime timeOfTheEvent;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "drivers_id")
	private Drivers drivers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_maintenance_category")
	private VehicleMaintenanceCategory maintenanceCategory;
	@Enumerated(EnumType.STRING) 
	private DamageRepaired damageRepaired;

	
	
	
	
}