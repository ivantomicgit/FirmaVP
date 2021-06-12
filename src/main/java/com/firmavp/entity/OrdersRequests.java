package com.firmavp.entity;



import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.firmavp.enums.OrdersRequestsType;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class OrdersRequests extends BaseEntity {
	private String orderNumber;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idIssuer")
	private Staff staff;
	private String description;
	private String delivered;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRecordsManagementOffice")
	private Address address;
	private OrdersRequestsType type;






}
