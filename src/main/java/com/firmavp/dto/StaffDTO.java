package com.firmavp.dto;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firmavp.entity.Role;
import com.firmavp.entity.Staff;

public class StaffDTO {
	private int id;
	private String specijalnost;
	private String ime;
	private String prezime;
	private int menagerId;

	public int getMenagerId() {
		return menagerId;
	}
	public void setMenagerId(int menagerId) {
		this.menagerId = menagerId;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	private List<StaffDTO>employee;
	
	

	public StaffDTO() {
		super();
	}

	public StaffDTO(int id,int idMenager, String specijalnost, String ime, String prezime) {
		super();
		this.id = id;
		this.menagerId = idMenager;
		this.specijalnost = specijalnost;
		this.ime = ime;
		this.prezime = prezime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecijalnost() {
		return specijalnost;
	}
	public void setSpecijalnost(String specijalnost) {
		this.specijalnost = specijalnost;
	}
	public List<StaffDTO> getEmployee() {
		return employee;
	}
	public void setEmployee(List<StaffDTO> employee) {
		this.employee = employee;
	}
	

	
	
	

}
