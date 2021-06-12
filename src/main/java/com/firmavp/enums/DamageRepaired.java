package com.firmavp.enums;



public enum DamageRepaired {

	NO ("NO"),
	YES ("YES");
	

	private String type;
	
	private DamageRepaired(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

}
