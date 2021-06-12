package com.firmavp.entity;



import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
public class Warehouse extends BaseEntity{
	private String nameWarehouse;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
	private Address address;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;
	@OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<WarehouseInput>listWarehouseInput = new ArrayList<WarehouseInput>();
	@OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<WarehouseOutput>listWarehouseOutput = new ArrayList<WarehouseOutput>();


	public void addWarehouseInput(WarehouseInput warehouseInput) {
		listWarehouseInput.add(warehouseInput);
		warehouseInput.setWarehouse(this);
	}
	public void removeWarehouseInput(WarehouseInput warehouseInput) {
		listWarehouseInput.remove(warehouseInput);
		warehouseInput.setWarehouse(null);
	}


	public void addWarehouseOutput(WarehouseOutput warehouseOutput) {
		listWarehouseOutput.add(warehouseOutput);
		warehouseOutput.setWarehouse(this);
	}
	public void removeWarehouseOutput(WarehouseOutput warehouseOutput) {
		listWarehouseOutput.remove(warehouseOutput);
		warehouseOutput.setWarehouse(null);

	}

	
	
}
