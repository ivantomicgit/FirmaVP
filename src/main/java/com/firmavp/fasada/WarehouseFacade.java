package com.firmavp.fasada;

import com.firmavp.dto.WarehouseDTO;

public interface WarehouseFacade {
	WarehouseDTO save(WarehouseDTO warehouseDTO , Integer idCompany, Integer idAdress);
	void deleteById(Integer id);

}
