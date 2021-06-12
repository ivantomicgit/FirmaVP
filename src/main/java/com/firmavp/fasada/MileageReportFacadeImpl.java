package com.firmavp.fasada;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.firmavp.dto.MileageReportDTO;
import com.firmavp.dto.VehicleDTO;
import com.firmavp.entity.MileageReport;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.MileageReportMapper;
import com.firmavp.service.MileageReportService;
import com.firmavp.service.VehicleService;

@Component
public class MileageReportFacadeImpl implements MileageReportFacade {
	private final MileageReportService mileageReportService;
	private final MileageReportMapper mileageReportMapper;
	private final VehicleService vehicleService;
	
	

	@Autowired
	public MileageReportFacadeImpl(MileageReportService mileageReportService, MileageReportMapper mileageReportMapper, VehicleService vehicleService) {
		super();
		this.mileageReportService = mileageReportService;
		this.mileageReportMapper = mileageReportMapper;
		this.vehicleService = vehicleService;
	}
	

	@Override
	public MileageReportDTO save(@Valid MileageReportDTO mileageReportDTO, Integer idVehicle) {
		VehicleDTO vehicleDTO = null;
		try {
			vehicleDTO = vehicleService.findVehicle(idVehicle);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withError_code(HttpStatus.NOT_FOUND.name()).withMessage("").withDetail("Vehicle with id" + idVehicle + "not found.").build();
		}
		mileageReportDTO.setVehicle_id(vehicleDTO);
		MileageReport mileageReport = mileageReportMapper.toMileageReport(mileageReportDTO);
		mileageReport = mileageReportService.save(mileageReport);
		return mileageReportMapper.toMileageReportDTO(mileageReport);
	}

	

	@Override
	public MileageReportDTO findMileageReportById(Integer id) {
		MileageReport mileageReport = null;
		try {
			mileageReport = mileageReportService.findMileageReportById(id);
		} catch (Exception e) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND).withError_code(HttpStatus.NOT_FOUND.name()).withMessage("").withDetail("Mileage report with id" + id + "not found.").build();
		}
		
		return mileageReportMapper.toMileageReportDTO(mileageReport);
	}

	@Override
	public List<MileageReportDTO> findMileageReportByVehicle__Id(Integer idVehicle) {
		// TODO Auto-generated method stub
		return null;
	}

}
