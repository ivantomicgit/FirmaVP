package com.firmavp.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



public class VehicleDTO {

	private int id;
	private String vehicleName;
	private Set<DriversDTO>vozaci;
	private List<VehicleDamageReportDTO> lsitVehicleDamageReport = new ArrayList<VehicleDamageReportDTO>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String nazivVozila) {
		this.vehicleName = nazivVozila;
	}
	public Set<DriversDTO> getVozaci() {
		return vozaci;
	}
	public void setVozaci(Set<DriversDTO> vozaci) {
		this.vozaci = vozaci;
	}
	public List<VehicleDamageReportDTO> getLsitVehicleDamageReport() {
		return lsitVehicleDamageReport;
	}
	public void setLsitVehicleDamageReport(List<VehicleDamageReportDTO> lsitVehicleDamageReport) {
		this.lsitVehicleDamageReport = lsitVehicleDamageReport;
	}
	

	
}
