package com.firmavp.entity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.MapsId;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="company")
@Getter
@Setter
public class Company extends BaseEntity{

	private String companyName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="company", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Place>listPlaces;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="company", cascade=CascadeType.ALL)
    private List<Warehouse>listWarehouses;
	@OneToMany(mappedBy="company",cascade=CascadeType.ALL)
    private List<Staff>staffList;
	
	@OneToMany(mappedBy="company",cascade=CascadeType.ALL)
    private List<Vehicle>vehicleList;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
	private Address address;

	public void addStaff(Staff staff) {
		staffList.add(staff);
		staff.setCompany(this);
	}
	
	public void removeStaff(Staff staff) {
		staffList.remove(staff);
		staff.setCompany(null);
	}
	
	public void addPlace(Place place) {
		listPlaces.add(place);
		place.setCompany(this);
	}
	
	public void removePlace(Place place) {
		listPlaces.remove(place);
		place.setCompany(null);
	}
	
}
