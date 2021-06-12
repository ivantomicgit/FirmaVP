package com.firmavp.dto;

import java.time.LocalDateTime;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FuelPurchaseDTO {
	private int id;
	private Double litersOfFuel;
	private LocalDateTime timeOfPurchase;
	private VehicleDTO vehicle_id;
	private DriversDTO driver_id;
	private String receiptNumber;
	
	
	

}
