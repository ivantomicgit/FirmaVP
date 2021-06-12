package com.firmavp.mapper;

import java.util.List;



import com.firmavp.dto.DriversDTO;
import com.firmavp.entity.Drivers;

public interface DriversMapper {

	List<DriversDTO> toDriversDTOs(List<Drivers> list);

	Drivers toDrivers(DriversDTO driversDTO);

	DriversDTO toDriversDTO(Drivers drivers);

	List<Drivers> toDrivers(List<DriversDTO> list);
}
