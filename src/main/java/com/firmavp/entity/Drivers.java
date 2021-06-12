package com.firmavp.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;

import javax.persistence.OneToOne;



@Entity
@Getter
@Setter
public class Drivers extends BaseEntity{
	private String nationalIdentificationNumber;
	private String driverLicenceNumber;
	private String licenceCategories;//B, C
	@ManyToMany(mappedBy = "drivers")
	private Set<Vehicle>vehicles;

	@OneToMany(mappedBy = "drivers",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<VehicleDamageReport>demageReportList;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	private Staff staff;


	public void addVehicle (Vehicle vehicle) {
		vehicles.add(vehicle);
		vehicle.getDrivers().add(this);
	}
	
	public void removeVehicle (Vehicle vehicle) {
		vehicles.remove(vehicle);
		vehicle.getDrivers().remove(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
