package com.firmavp.dto;

public class LocationDTO {

	private int id;
	private String locationName;
	
	//ovde treba listaVozilaDTO
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazivLokacije() {
		return locationName;
	}
	public void setNazivLokacije(String nazivLokacije) {
		this.locationName = nazivLokacije;
	}
	
	
	
	
}
