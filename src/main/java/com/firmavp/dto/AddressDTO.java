package com.firmavp.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
	
	private int id;
	private String city;
	private String street;
	private String postalCode;
	List<WarehouseDTO> listWerhouses = new ArrayList<WarehouseDTO>();
	
}
