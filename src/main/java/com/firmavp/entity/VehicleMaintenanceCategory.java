package com.firmavp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VehicleMaintenanceCategory extends BaseEntity{
	
	private String categoryName;
	
	@OneToMany(mappedBy = "maintenance_category", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VehicleDescriptionOfMaintenance>listVehicleMaintenanceDescriptions = new ArrayList<VehicleDescriptionOfMaintenance>();
	@OneToMany(mappedBy = "maintenanceCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VehicleDamageReport>demageReportList;

	public void addDescriptionOfMaintenance(VehicleDescriptionOfMaintenance vehicleDescriptionOfMaintenance) {
		listVehicleMaintenanceDescriptions.add(vehicleDescriptionOfMaintenance);
		vehicleDescriptionOfMaintenance.setMaintenance_category(this);
	}
	
	public void removeDescriptionOfMaintenance(VehicleDescriptionOfMaintenance vehicleDescriptionOfMaintenance) {
		listVehicleMaintenanceDescriptions.remove(vehicleDescriptionOfMaintenance);
		vehicleDescriptionOfMaintenance.setMaintenance_category(null);
	}
}
