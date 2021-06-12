package com.firmavp.dto;

import java.util.ArrayList;
import java.util.List;
import com.firmavp.dto.WarehouseInputDTO;
import com.firmavp.dto.WarehouseOutputDTO;


public class WarehouseDTO {
	
	private int id;
	private String nameWarehouse;
	private List<WarehouseOutputDTO>listWarehouseOutput=new ArrayList<WarehouseOutputDTO>();
	private List<WarehouseInputDTO> listWarehouseInput=new ArrayList<WarehouseInputDTO>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameWarehouse() {
		return nameWarehouse;
	}
	public void setNameWarehouse(String nameWarehouse) {
		this.nameWarehouse = nameWarehouse;
	}
	public List<WarehouseOutputDTO> getListWarehouseOutput() {
		return listWarehouseOutput;
	}
	public void setListWarehouseOutput(List<WarehouseOutputDTO> listWarehouseOutput) {
		this.listWarehouseOutput = listWarehouseOutput;
	}
	public List<WarehouseInputDTO> getListWarehouseInput() {
		return listWarehouseInput;
	}
	public void setListWarehouseInput(List<WarehouseInputDTO> listWarehouseInput) {
		this.listWarehouseInput = listWarehouseInput;
	}


}
