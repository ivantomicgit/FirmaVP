package com.firmavp.dto;

import java.util.ArrayList;
import java.util.List;



public class VehicleCategoryDTO {

	private int id;
	private String categoryName;	
	private List<VehicleRegistrationDTO> lsitVehicleRegistrations = new ArrayList<VehicleRegistrationDTO>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<VehicleRegistrationDTO> getLsitVehicleRegistrations() {
		return lsitVehicleRegistrations;
	}
	public void setLsitVehicleRegistrations(List<VehicleRegistrationDTO> lsitVehicleRegistrations) {
		this.lsitVehicleRegistrations = lsitVehicleRegistrations;
	}
	
	
	
}
