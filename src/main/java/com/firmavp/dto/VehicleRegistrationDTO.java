package com.firmavp.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VehicleRegistrationDTO {
	
	private int id;

    private String vehicleRegistrationNumber;
   
	private String ownersName;
		
	private String vehicleModel;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfManufacture;
	
	private String fuelUsed;
	
	private String chassisNumber;
	
	private String engineNumber;
	
	private String vehicleBodyType;
	
	private int cubicCapacity;
	
	private int seatingCapacity;
	
	private String wheelbase;
	
	private String vehicleColor;
	
	private String unladenWeight;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfRegistration;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfRegistrationExpiry;
	
	private String ownersSignature;
   
	
}
