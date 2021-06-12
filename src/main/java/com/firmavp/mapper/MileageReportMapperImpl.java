package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.MileageReportDTO;
import com.firmavp.entity.MileageReport;
@Component
public class MileageReportMapperImpl implements MileageReportMapper{
	private final VehicleMapper vozilaMapper;
	private final DriversMapper driversMapper;
	
	

	@Autowired
	public MileageReportMapperImpl(VehicleMapper vozilaMapper, DriversMapper driversMapper) {
		super();
		this.vozilaMapper = vozilaMapper;
		this.driversMapper = driversMapper;
	}

	@Override
	public MileageReport toMileageReport(@Valid MileageReportDTO mileageReportDTO) {
		MileageReport mileageReport = new MileageReport();
		mileageReport.setId(mileageReportDTO.getId());
		mileageReport.setDateOfEntry(mileageReportDTO.getDateOfEntry());
		mileageReport.setNumberOfHours(mileageReportDTO.getNumberOfHours());
		mileageReport.setNumberOfKilometers(mileageReportDTO.getNumberOfKilometers());
		mileageReport.setVehicle(vozilaMapper.toVehicle(mileageReportDTO.getVehicle_id()));
		mileageReport.setDrivers(driversMapper.toDrivers(mileageReportDTO.getDrivers_id()));
		return mileageReport;
	}

	@Override
	public MileageReportDTO toMileageReportDTO(MileageReport mileageReport) {
		MileageReportDTO mileageReportDTO = new MileageReportDTO();
		mileageReportDTO.setId(mileageReport.getId());
		mileageReportDTO.setDateOfEntry(mileageReport.getDateOfEntry());
		mileageReportDTO.setNumberOfHours(mileageReport.getNumberOfHours());
		mileageReportDTO.setNumberOfKilometers(mileageReport.getNumberOfKilometers());
		mileageReportDTO.setVehicle_id(vozilaMapper.toVehicleDTO(mileageReport.getVehicle()));
		mileageReportDTO.setDrivers_id(driversMapper.toDriversDTO(mileageReport.getDrivers()));
		return mileageReportDTO;
	}

	@Override
	public List<MileageReportDTO> toMileageReportDTOs(List<MileageReport> list) {
		List<MileageReportDTO> listMileageReportDTOs = new ArrayList<MileageReportDTO>();
		for (MileageReport mileageReport : list) {
			MileageReportDTO mileageReportDTO = new MileageReportDTO();
			mileageReportDTO.setId(mileageReport.getId());
			mileageReportDTO.setDateOfEntry(mileageReport.getDateOfEntry());
			mileageReportDTO.setNumberOfHours(mileageReport.getNumberOfHours());
			mileageReportDTO.setNumberOfKilometers(mileageReport.getNumberOfKilometers());
			mileageReportDTO.setVehicle_id(vozilaMapper.toVehicleDTO(mileageReport.getVehicle()));
			mileageReportDTO.setDrivers_id(driversMapper.toDriversDTO(mileageReport.getDrivers()));
			listMileageReportDTOs.add(mileageReportDTO);
		}
		return listMileageReportDTOs;
	}

}
