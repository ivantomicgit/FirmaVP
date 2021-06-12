package com.firmavp.entity;



import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
@Getter
@Setter
public class VehicleCategory extends BaseEntity{

	private String categoryName;
	
	@OneToMany(mappedBy="vehicleCategory", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Vehicle> listVehicles;

}
