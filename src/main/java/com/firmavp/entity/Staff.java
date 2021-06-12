package com.firmavp.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "staff")

@Getter
@Setter
public class Staff extends BaseEntity implements UserDetails{
	
	@Column(length = 56)
	private String firstNameStaff;
	@Column(length = 56)
	private String lastNameStaff;
	@Column(length = 56, unique = true)
	private String username;
	@Column(length = 100)
	private String password;
	private boolean enabled;
	private String phoneNumberStaff;
	private String colorStaff;
	private int pomocna;
	private String adress;
	private String note;
	private String picture;
	private String fbProfile;
	private String instagram;
	private String email;
	private String specialty;
	private int fontSize;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Temporal(TemporalType.DATE)
	private Date dateOfPasswordLastChange;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workplace_id")

	private Workplace workplace;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place")
	private Place place;
	@ManyToOne
	@JoinColumn(name = "company")
	private Company company;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "staff_roles", joinColumns = @JoinColumn(name = " idStaff"), inverseJoinColumns = @JoinColumn(name = "idRoles"))
	private Set<Role> roles;
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinColumn(name="manager_id")
	private Staff manager;


	@OneToMany(mappedBy="manager")
	private Set<Staff> subordinates = new HashSet<Staff>();


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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : roles) {
			String name = role.getRoleName().toUpperCase();
			authorities.add(new SimpleGrantedAuthority(name));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	


}