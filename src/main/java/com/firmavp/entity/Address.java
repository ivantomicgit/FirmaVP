package com.firmavp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Address extends BaseEntity{
	
	private String city;
	private String street;
	private String postalCode;
	
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY, optional = false)
    private Company company; 
	
	@OneToMany( mappedBy = "address", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Warehouse> listWarhouses = new ArrayList<Warehouse>();
	
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehicle> listVehicles = new ArrayList<Vehicle>();

	public void addWarehouse(Warehouse warehouse) {
		listWarhouses.add(warehouse);
		warehouse.setAddress(this);
	}
    
	public void removeWarehouse(Warehouse warehouse) {
		listWarhouses.remove(warehouse);
		warehouse.setAddress(null);
	}
	
	public void addVehicle(Vehicle vehicle) {
		listVehicles.add(vehicle);
		vehicle.setAddress(this);
	}
    
	public void removeVehicle(Vehicle vehicle) {
		listVehicles.remove(vehicle);
		vehicle.setAddress(null);
	}

}
