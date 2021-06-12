package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.WarehouseOutputDTO;
import com.firmavp.dto.WarehouseInputDTO;
import com.firmavp.entity.WarehouseOutput;
import com.firmavp.entity.WarehouseInput;

@Component
public class WarehouseOutputMapperImpl implements WarehouseOutputMapper {
	

	

	@Override
	public WarehouseOutputDTO toWarehouseOutputDTO(WarehouseOutput warehouseOutput) {
		
		WarehouseOutputDTO warehouseOutputDTO = new WarehouseOutputDTO();
		warehouseOutputDTO.setIdProduct( warehouseOutput.getProduct().getId());
		warehouseOutputDTO.setAmount( warehouseOutput.getAmount());
		warehouseOutputDTO.setOutputTime( warehouseOutput.getOutputTime());
	    
		return  warehouseOutputDTO;
	}

	@Override
	public WarehouseOutput toWarehouseOutput(WarehouseOutputDTO warehouseOutputDTO ) {
		
		WarehouseOutput warehouseOutput= new WarehouseOutput();
		warehouseOutput.setId(warehouseOutput.getId());;
		warehouseOutput.setAmount( warehouseOutputDTO.getAmount());
		warehouseOutput.setOutputTime( warehouseOutputDTO.getOutputTime());
		return warehouseOutput;
	}

	@Override
	public List<WarehouseOutputDTO> toWarehouseDTOs(List<WarehouseOutput> listWarehouseOutput) {
		List<WarehouseOutputDTO>warehouseOutputDTOs = new ArrayList<WarehouseOutputDTO>();
		for(WarehouseOutput i : listWarehouseOutput) {
			WarehouseOutputDTO warehouseOutputDTO = new WarehouseOutputDTO();
			warehouseOutputDTO.setIdProduct(i.getProduct().getId());
			warehouseOutputDTO.setAmount(i.getAmount());
			warehouseOutputDTO.setOutputTime(i.getOutputTime());
			warehouseOutputDTOs.add(warehouseOutputDTO);
		}
		return warehouseOutputDTOs;
	}

	@Override
	public List<WarehouseOutput> toWarehouseOutputs(List<WarehouseOutputDTO> warehouseOutputDTOs) {
		
		List<WarehouseOutput>warehouseOutputs = new ArrayList<WarehouseOutput>();
		for(WarehouseOutputDTO il : warehouseOutputDTOs) {
			WarehouseOutput warehouseOutput = new WarehouseOutput();
			warehouseOutput.setId(warehouseOutput.getId());;
			warehouseOutput.setAmount(il.getAmount());
			warehouseOutput.setOutputTime(il.getOutputTime());
			warehouseOutputs.add(warehouseOutput);
		}
			return warehouseOutputs;
	}

}
