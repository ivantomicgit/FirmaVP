package com.firmavp.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="workplace")
@Getter
@Setter
public class Workplace extends BaseEntity{

	private String workplaceName;
	
	@OneToMany(mappedBy="workplace",orphanRemoval = true,cascade=CascadeType.ALL)
	private List<Staff>listEmployees;


	public void addStaff (Staff staff) {
		listEmployees.add(staff);
		staff.setWorkplace(this);
	}
	
	public void removeStaff (Staff staff) {
		listEmployees.remove(staff);
		staff.setWorkplace(null);
	}

}