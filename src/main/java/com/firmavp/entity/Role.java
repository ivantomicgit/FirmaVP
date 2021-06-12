package com.firmavp.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.ManyToMany;
@Entity
@Getter
@Setter
public class Role extends BaseEntity{

	@Column(length=56,unique=true)
	private String roleName;
	@ManyToMany(mappedBy="roles", fetch = FetchType.LAZY)
	private Set<Staff>users;
	
	public void addStaff (Staff staff) {
		users.add(staff);
		staff.getRoles().add(this);
	}
	
	public void removeStaff (Staff staff) {
		users.remove(staff);
		staff.getRoles().remove(this);
	}

	public Role() {
		super();
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
