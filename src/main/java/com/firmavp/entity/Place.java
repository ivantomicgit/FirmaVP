package com.firmavp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "place")
@Getter
@Setter
public class Place extends BaseEntity {

	private String placeName;
	private String placeAddress;
	private String placeContact;
	private String placeColor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyID")
	private Company company;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "place", cascade = CascadeType.ALL)
	private List<Staff> staffList;

	public void addStaff(Staff staff) {
		staffList.add(staff);
		staff.setPlace(this);
	}

	public void removeStaff(Staff staff) {
		staffList.remove(staff);
		staff.setPlace(null);
	}
}