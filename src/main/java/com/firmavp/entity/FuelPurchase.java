package com.firmavp.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Getter
@Setter
public class FuelPurchase extends BaseEntity{
	private Double litersOfFuel;
	private LocalDateTime timeOfPurchase;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driver_id")
	private Drivers driver;
	private String receiptNumber;

}
