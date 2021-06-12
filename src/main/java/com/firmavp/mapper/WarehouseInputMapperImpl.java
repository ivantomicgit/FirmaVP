package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.firmavp.dto.WarehouseInputDTO;
import com.firmavp.entity.WarehouseInput;
@Component
public class WarehouseInputMapperImpl implements WarehouseInputMapper {

	@Override
	public WarehouseInputDTO toWarehouseInputDTO(WarehouseInput warehouseInput) {
		WarehouseInputDTO warehouseInputDTO = new WarehouseInputDTO();
	    warehouseInputDTO.setIdProduct(warehouseInput.getProduct().getId());
	    warehouseInputDTO.setAmount(warehouseInput.getAmount());
	    warehouseInputDTO.setInputTime(warehouseInput.getInputTime());
	    
		return  warehouseInputDTO;
	}

	@Override
	public WarehouseInput toWarehouseInput(WarehouseInputDTO warehouseInputDTO) {
		WarehouseInput warehouseInput = new WarehouseInput();
		warehouseInput.setId(warehouseInput.getId());;
		warehouseInput.setAmount(warehouseInputDTO.getAmount());
		warehouseInput.setInputTime(warehouseInputDTO.getInputTime());
		return warehouseInput;
	}

	@Override
	public List<WarehouseInputDTO> toWarehouseInputDTOs(List<WarehouseInput> listWarehouseInputs) {
		List<WarehouseInputDTO>warehouseInputDTOs = new ArrayList<WarehouseInputDTO>();
		for(WarehouseInput u : listWarehouseInputs) {
			WarehouseInputDTO warehouseInputDTO = new WarehouseInputDTO();
		    warehouseInputDTO.setIdProduct(u.getProduct().getId());
			warehouseInputDTO.setAmount(u.getAmount());
			warehouseInputDTO.setInputTime(u.getInputTime());
		    warehouseInputDTOs.add(warehouseInputDTO);
		}
		return warehouseInputDTOs;
	}

	@Override
	public List<WarehouseInput> toWarehouseInputs(List<WarehouseInputDTO> warehouseInputDTOs) {
	List<WarehouseInput>warehouseInputs = new ArrayList<WarehouseInput>();
	for(WarehouseInputDTO ul : warehouseInputDTOs) {
		WarehouseInput warehouseInput = new WarehouseInput();
		warehouseInput.setId(warehouseInput.getId());;
		warehouseInput.setAmount(ul.getAmount());
		warehouseInput.setInputTime(ul.getInputTime());
		warehouseInputs.add(warehouseInput);
	}
		return warehouseInputs;
	}

}
