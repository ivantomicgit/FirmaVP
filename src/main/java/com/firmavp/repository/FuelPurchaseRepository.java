package com.firmavp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.FuelPurchase;
@Repository
public interface FuelPurchaseRepository extends JpaRepository<FuelPurchase, Integer>{

	FuelPurchase findFuelPurchaseById(Integer id);

	@Query(nativeQuery = true, value = "select sum(liters_of_fuel) from fuel_purchase as f where f.driver_id=? AND f.vehicle_id=? AND f.time_of_purchase BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59')")
	Double allFuelPurchasedByDriverAndVehicle(Integer driver_id, Integer vehicle_id);

}
