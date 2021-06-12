package com.firmavp.service;

import java.util.List;

import com.firmavp.dto.WarehouseOutputDTO;
import com.firmavp.entity.WarehouseOutput;

public interface WarehouseOutputService {

	WarehouseOutputDTO save(WarehouseOutput warehouseOutput);

	void deleteById(Integer id);

	List<WarehouseOutput> listOfOutputs();

//	WarehouseOutputDTO updateOutput(Integer idProizvoda, WarehouseOutputDTO izlazMagacinDTO);

}
