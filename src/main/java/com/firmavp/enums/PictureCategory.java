package com.firmavp.enums;

public enum PictureCategory {
		STAFF ("Staff"),
		PRODUCT ("Product"),
		VEHICLE ("Vehicle"),
		FUEL_PURCHASE ("FuelPurchase"),
		MILEAGE_REPORT ("MileageReport"),
		VEHICLE_DAMAGE_REPORT("VehicleDamageReport")
		
		
		
		;
		
		
		

		
		
		private String category;
		
		

		private PictureCategory(String category) {
			this.category = category;
		}



		public String getCategory() {
			return category;
		}

}
