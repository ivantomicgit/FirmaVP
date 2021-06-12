package com.firmavp.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompanyDTO {
	
	private int id;
    private String companyName;
    private List<PlaceDTO>listPlacesDTO = new ArrayList<PlaceDTO>();
    private List<WarehouseDTO>listWarehouseDTOs = new ArrayList<WarehouseDTO>();
      
}
