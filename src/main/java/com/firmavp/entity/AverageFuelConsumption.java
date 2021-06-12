package com.firmavp.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class AverageFuelConsumption extends BaseEntity{
	
	private Double consumptionPerHour;
	private Double consumptionPer100km;
	private String workDescription;
	private String note;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id", unique = true)
	private Vehicle vehicle;

}
