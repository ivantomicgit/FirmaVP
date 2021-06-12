package com.firmavp.entity;



import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class WarehouseInput extends BaseEntity{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	private Double amount;
	private LocalDateTime inputTime;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_warehouse")
	private Warehouse warehouse;


}
