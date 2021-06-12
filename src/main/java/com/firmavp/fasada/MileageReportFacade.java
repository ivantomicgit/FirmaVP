package com.firmavp.fasada;

import java.util.List;

import javax.validation.Valid;

import com.firmavp.dto.MileageReportDTO;

public interface MileageReportFacade {

	MileageReportDTO save(@Valid MileageReportDTO mileageReportDTO, Integer idVehicle);

	MileageReportDTO findMileageReportById(Integer id);

	List<MileageReportDTO> findMileageReportByVehicle__Id(Integer idVehicle);

}
