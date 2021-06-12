package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.WarehouseDTO;

import com.firmavp.entity.Warehouse;
@Component
public class WarehouseMapperImpl  implements WarehouseMapper{
	
	private final WarehouseOutputMapper outputMapper;
	private final WarehouseInputMapper inputMapper;
    
	@Autowired
	public WarehouseMapperImpl(WarehouseOutputMapper outputMapper, WarehouseInputMapper inputMapper) {
		super();
		this.outputMapper = outputMapper;
		this.inputMapper = inputMapper;
	}

	@Override
	public WarehouseDTO toWarehouseDTO(Warehouse warehouse) {
		WarehouseDTO warehouseDTO = new WarehouseDTO();
		warehouseDTO.setId(warehouse.getId());
		warehouseDTO.setNameWarehouse(warehouse.getNameWarehouse());
	   warehouseDTO.setListWarehouseInput(inputMapper.toWarehouseInputDTOs(warehouse.getListWarehouseInput()));
	   warehouseDTO.setListWarehouseOutput(outputMapper.toWarehouseDTOs(warehouse.getListWarehouseOutput()));
	    return  warehouseDTO;
	}

	@Override
	public Warehouse toWarehouse(WarehouseDTO warehouseDTO) {
		Warehouse warehouse = new Warehouse();
		warehouse.setId(warehouseDTO.getId());
		warehouse.setNameWarehouse(warehouseDTO.getNameWarehouse());
	    warehouse.setListWarehouseInput(inputMapper.toWarehouseInputs(warehouseDTO.getListWarehouseInput()));
	    warehouse.setListWarehouseOutput(outputMapper.toWarehouseOutputs(warehouseDTO.getListWarehouseOutput()));
		return warehouse;
	}

	@Override
	public List<WarehouseDTO> toWarehouseDTOs(List<Warehouse> listWarehouse) {
		List<WarehouseDTO>warehouseDTOs = new ArrayList<WarehouseDTO>();
		for(Warehouse warehouse : listWarehouse) {
			WarehouseDTO warehouseDTO = new WarehouseDTO();
			warehouseDTO.setId(warehouse.getId());
			warehouseDTO.setNameWarehouse(warehouse.getNameWarehouse());
		    warehouseDTO.setListWarehouseInput(inputMapper.toWarehouseInputDTOs(warehouse.getListWarehouseInput()));
		   warehouseDTO.setListWarehouseOutput(outputMapper.toWarehouseDTOs(warehouse.getListWarehouseOutput()));

			warehouseDTOs.add(warehouseDTO);
			
		}
		return warehouseDTOs;
	}

	@Override
	public List<Warehouse> toWarehouses(List<WarehouseDTO> warehouseDTOs) {
		List<Warehouse>warehouses=new ArrayList<Warehouse>();
		for(WarehouseDTO warehouseDTO : warehouseDTOs) {
			Warehouse warehouse = new Warehouse();
			warehouse.setId(warehouseDTO.getId());
			warehouse.setNameWarehouse(warehouseDTO.getNameWarehouse());
		   warehouse.setListWarehouseInput(inputMapper.toWarehouseInputs(warehouseDTO.getListWarehouseInput()));
		   warehouse.setListWarehouseOutput(outputMapper.toWarehouseOutputs(warehouseDTO.getListWarehouseOutput()));

			warehouses.add(warehouse);
		}
		return warehouses;
	}

	/* @Override
	public List<WarehouseDTO> toWarehouseInputDTOs(List<Warehouse> listWarehouse) {
		List<WarehouseDTO>warehouseDTOs = new ArrayList<WarehouseDTO>();
		for(Warehouse warehouse : listWarehouse) {
			WarehouseDTO warehouseDTO = new WarehouseDTO();
			warehouseDTO.setId(warehouse.getId());
			warehouseDTO.setNameWarehouse(warehouse.getNameWarehouse());
		    warehouseDTO.setListWarehouseInput(inputMapper.toWarehouseInputDTOs(warehouse.getListWarehouseInput()));
		    warehouseDTOs.add(warehouseDTO);
	
		}
		return warehouseDTOs;
	}

	@Override
	public List<WarehouseDTO> toWarehouseOutputDTOs(List<Warehouse> listWarehouse) {
		
		List<WarehouseDTO>warehouseDTOs = new ArrayList<WarehouseDTO>();
		for(Warehouse warehouse : listWarehouse) {
			WarehouseDTO warehouseDTO = new WarehouseDTO();
			warehouseDTO.setId(warehouse.getId());
			warehouseDTO.setNameWarehouse(warehouse.getNameWarehouse());
		     warehouseDTO.setListWarehouseOutput(outputMapper.toWarehouseDTOs(warehouse.getListWarehouseOutput()));
		    warehouseDTOs.add(warehouseDTO);
	
		}
		return warehouseDTOs;
*/
}

