package com.firmavp.service;

import java.util.List;

import com.firmavp.dto.WarehouseInputDTO;
import com.firmavp.entity.WarehouseInput;

public interface WarehouseInputService {

	WarehouseInputDTO save(WarehouseInput warehouseInput);

	List<WarehouseInput> listOfInputs();

	void deleteById(Integer id);

	//WarehouseInputDTO updateUlaz(Integer idProizvoda, WarehouseInputDTO ulazMagacinDTO);

	

}
