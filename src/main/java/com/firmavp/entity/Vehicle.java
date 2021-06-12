package com.firmavp.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;
import javax.persistence.*;


@Entity
@Getter
@Setter
public class Vehicle extends BaseEntity {

	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
	private Address address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VehicleDamageReport> lsitVehicleDamageReport;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private VehicleCategory vehicleCategory;	

	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VehicleRegistration> lsitVehicleRegistrations = new ArrayList<VehicleRegistration>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "vehicle_driver", joinColumns = @JoinColumn(name = "vehicle_id"), inverseJoinColumns = @JoinColumn(name = "driver_id"))
	private Set<Drivers> drivers;

	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VehicleDescriptionOfMaintenance> listVehicleMaintenance = new ArrayList<VehicleDescriptionOfMaintenance>();

	private String vehicleName;

	@OneToOne(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH })
	private AverageFuelConsumption averageFuelConsumption;

	public void removeDrivers(Drivers driver) {
		drivers.remove(driver);
		driver.getVehicles().remove(this);
	}

	public void addDrivers(Drivers driver) {
		drivers.add(driver);
		driver.getVehicles().add(this);
	}

	public void addDescriptionOfMaintenance(VehicleDescriptionOfMaintenance vehicleDescriptionOfMaintenance) {
		listVehicleMaintenance.add(vehicleDescriptionOfMaintenance);
		vehicleDescriptionOfMaintenance.setVehicle(this);
	}

	public void removeDescriptionOfMaintenance(VehicleDescriptionOfMaintenance vehicleDescriptionOfMaintenance) {
		listVehicleMaintenance.remove(vehicleDescriptionOfMaintenance);
		vehicleDescriptionOfMaintenance.setVehicle(null);
	}

	@Override
	public int hashCode() {

		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
