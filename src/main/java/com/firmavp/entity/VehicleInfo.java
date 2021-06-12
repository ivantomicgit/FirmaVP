package com.firmavp.entity;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class VehicleInfo extends BaseEntity{

	// izvor:
	// https://www.coverfox.com/driving-license/registration-certificate/

//	Vehicle registration number
//	Name and address of the vehicle owner
//	Maker’s class and vehicle class
//	Month and year of vehicle manufacture
//	Fuel used
//	Chassis number and engine number
//	Type of vehicle body
//	Cubic capacity
//	Seating capacity
//	Wheelbase
//	Colour of the vehicle
//	Unladen weight
//	Date of registration and expiry date
//	Signature of the owner
	
	private String vehicleRegistrationNumber;
	
	private String ownersName;
		
	private String vehicleModel;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfManufacture;
	
	private String fuelUsed;
	
	private String chassisNumber;
	
	private String engineNumber;
	
	private String vehicleBodyType;
	@NotNull(message = "Cubic capacity may not be null")
	private int cubicCapacity;
	@NotNull(message = "Seating capacity may not be null")
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
