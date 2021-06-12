package com.firmavp.dto;

import java.time.LocalDateTime;
import java.util.List;

public class WarehouseInputDTO {
	private int idProduct;
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	private Double amount;
	private LocalDateTime inputTime;

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDateTime getInputTime() {
		return inputTime;
	}
	public void setInputTime(LocalDateTime inputTime) {
		this.inputTime = inputTime;
	

}
}
