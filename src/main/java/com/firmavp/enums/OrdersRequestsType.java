package com.firmavp.enums;

public enum OrdersRequestsType {
	WORKORDER ("WorkOrder"),
	WORKREQUEST ("WorkRequest");
	
	
	

	
	
	private String type;
	
	

	private OrdersRequestsType(String type) {
		this.type = type;
	}



	public String getType() {
		return type;
	}

	
}
