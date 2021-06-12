package com.firmavp.dto;

import java.time.LocalDateTime;
import java.util.List;

public class WarehouseOutputDTO {
	
	private int idProduct;
	private Double amount;
	private LocalDateTime outputTime;
		
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDateTime getOutputTime() {
		return outputTime;
	}
	public void setOutputTime(LocalDateTime outputTime) {
		this.outputTime = outputTime;
	

}
}
