package com.firmavp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


import java.time.LocalDate;


@Entity
@Table(name="work_orders_requests")
@Getter
@Setter
public class WorkOrdersRequests extends OrdersRequests {
	private LocalDate dateOfIssue;
	private LocalDate deadline;

	
	







}
