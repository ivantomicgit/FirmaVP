package com.firmavp.mapper;

import java.util.List;

import javax.validation.Valid;

import com.firmavp.dto.MileageReportDTO;
import com.firmavp.entity.MileageReport;

public interface MileageReportMapper {

	MileageReport toMileageReport(@Valid MileageReportDTO mileageReportDTO);

	MileageReportDTO toMileageReportDTO(MileageReport mileageReport);

	List<MileageReportDTO> toMileageReportDTOs(List<MileageReport> list);

}
