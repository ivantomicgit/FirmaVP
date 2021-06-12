package com.firmavp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class MileageReport extends BaseEntity {
	private LocalDate dateOfEntry;
	private Double numberOfKilometers;
	private Double numberOfHours;
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driver_id")
	private Drivers drivers;

	
	
	


}
