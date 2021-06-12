package com.firmavp.entity;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="notice_of_execution_of_work_orders_requests")
@Getter
@Setter
public class NoticeOfExecutionOfWorkOrdersRequests extends OrdersRequests {
	private LocalDate dateOfExecution;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idWorkOrdersRequests")
	private WorkOrdersRequests workOrdersRequests;

	

	
	

}




