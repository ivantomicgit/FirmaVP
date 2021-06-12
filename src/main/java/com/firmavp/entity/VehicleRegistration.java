package com.firmavp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Getter
@Setter
public class VehicleRegistration extends VehicleInfo {

    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;

	
	
}
