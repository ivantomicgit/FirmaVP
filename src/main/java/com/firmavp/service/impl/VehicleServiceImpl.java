package com.firmavp.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.VehicleDTO;
import com.firmavp.dto.VehicleDamageReportDTO;
import com.firmavp.entity.VehicleCategory;
import com.firmavp.entity.VehicleDescriptionOfMaintenance;
import com.firmavp.enums.DamageRepaired;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.entity.Company;
import com.firmavp.entity.Vehicle;
import com.firmavp.mapper.CompanyMapper;
import com.firmavp.mapper.VehicleDamageReportMapper;
import com.firmavp.mapper.VehicleMapper;
import com.firmavp.repository.CompanyRepository;
import com.firmavp.repository.VehicleCategoryRepository;
import com.firmavp.repository.VehicleDamageReportRepository;
import com.firmavp.repository.VehicleRepository;
import com.firmavp.service.CompanyService;
import com.firmavp.service.VehicleDamageReportService;
import com.firmavp.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	private final VehicleRepository vehicleRepository;
	private final VehicleMapper vehicleMapper;
	private final VehicleCategoryRepository vehicleCategoryRepository;
	private final CompanyService companyService;
	private final CompanyMapper companyMapper;
	private final CompanyRepository companyRepository;

	private final VehicleDamageReportService vehicleDamageReportService;
	private final VehicleDamageReportMapper vehicleDamageReportMapper;
	private final VehicleDamageReportRepository vehicleDamageReportRepository;

	@Autowired
	public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper,
			VehicleCategoryRepository vehicleCategoryRepository, CompanyService companyService,
			CompanyMapper companyMapper, VehicleDamageReportService vehicleDamageReportService,
			VehicleDamageReportMapper vehicleDamageReportMapper,
			VehicleDamageReportRepository vehicleDamageReportRepository, CompanyRepository companyRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
		this.vehicleMapper = vehicleMapper;
		this.vehicleCategoryRepository = vehicleCategoryRepository;
		this.companyService = companyService;
		this.companyMapper = companyMapper;
		this.vehicleDamageReportService = vehicleDamageReportService;
		this.vehicleDamageReportMapper = vehicleDamageReportMapper;
		this.vehicleDamageReportRepository = vehicleDamageReportRepository;
		this.companyRepository = companyRepository;
	}

	@Override
	@Transactional
	public VehicleDTO save(VehicleDTO vehicleDTO, Integer idVehicleCategory, Integer idCompany) {
		VehicleCategory vehicleCategory = vehicleCategoryRepository.findVehicleCategoryById(idVehicleCategory);
		if (vehicleCategory == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no category for id " + idVehicleCategory)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		Company company = companyMapper.toCompany(companyService.findCompany(idCompany));

		if (company == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no company for id " + idCompany)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}

		Vehicle vehicle = new Vehicle();

		vehicle.setVehicleCategory(vehicleCategory);
		vehicle.setCompany(company);
		vehicle.setVehicleName(vehicleDTO.getVehicleName());

		vehicleRepository.save(vehicle);
		VehicleDTO vozilaDTO2 = vehicleMapper.toVehicleDTO(vehicle);

		return vozilaDTO2;
	}

	@Override
	@Transactional(readOnly = true)
	public VehicleDTO findVehicle(Integer id) {
		Vehicle vehicleFromDatabase = vehicleRepository.findVehicleById(id);
		if (vehicleFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no vehicle in database fod d " + id)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}

		return vehicleMapper.toVehicleDTO(vehicleFromDatabase);
	}

	@Override
	@Transactional(readOnly = true)
	public List<VehicleDTO> findAll() {
		List<VehicleDTO> listVehicleDTO = vehicleMapper.toListVehiclesDTO(vehicleRepository.findAll());
		return listVehicleDTO;
	}

	@Override
	@Transactional
	public VehicleDTO update(VehicleDTO vehicleDTO, Integer idVehicleCategory, Integer idCompany) {
		VehicleCategory vehicleCategory = vehicleCategoryRepository.findVehicleCategoryById(idVehicleCategory);
		if (vehicleCategory == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no category for id" + idVehicleCategory)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		Company company = companyMapper.toCompany(companyService.findCompany(idCompany));

		if (company == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no company for id " + idCompany)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}

		Vehicle vehicle = vehicleMapper.toVehicle(vehicleDTO);
		vehicle.setVehicleCategory(vehicleCategory);
		vehicle.setCompany(company);
		vehicle.setVehicleName(vehicleDTO.getVehicleName());
		vehicle.setId(vehicleDTO.getId());
		vehicleRepository.save(vehicle);

		return vehicleMapper.toVehicleDTO(vehicle);
	}

	@Override
	@Transactional
	public List<VehicleDTO> findVehiclesForCompanyId(Integer companyId) {

		Company company = companyRepository.findCompanyById(companyId);

		List<Vehicle> listVehicles = company.getVehicleList();

		return vehicleMapper.toListVehiclesDTO(listVehicles);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Vehicle vehicle = vehicleRepository.findVehicleById(id);
		if (vehicle == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no vehicle for id" + id)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		vehicleRepository.delete(vehicle);
	}

	@Override
	@Transactional(readOnly = true)
	public List<VehicleDTO> findAllDamagedVehicles(Integer idCompany) {

		List<VehicleDTO> listVehicleDTO = findVehiclesForCompanyId(idCompany);
		List<VehicleDTO> damagedVehicleList = new ArrayList<VehicleDTO>();

		for (VehicleDTO vehicleDTO : listVehicleDTO) {
			for (VehicleDamageReportDTO dr : vehicleDTO.getLsitVehicleDamageReport()) {
				if (dr.getDamageRepaired().equals(DamageRepaired.NO)) {
					damagedVehicleList.add(vehicleDTO);
					break;
				}
			}
		}
		return damagedVehicleList;

	}
	
	@Override
	@Transactional(readOnly = true)
	public VehicleDTO findAllDamagesForVehicle(Integer idCompany, Integer idVehicle) {

		List<VehicleDTO> damagedVehicleList = findAllDamagedVehicles(idCompany);
       
         for(VehicleDTO vehDTO : damagedVehicleList) {
 			if(vehDTO.getId() == idVehicle) {
 				return vehDTO;
 			}
         }
         
		return null;

	}

	@Override
	@Transactional(readOnly = true)
	public VehicleDamageReportDTO findDamageReport(Integer idCompany, Integer idVehicle, Integer idDamageReport) {
		VehicleDTO vehicleDTO = findAllDamagesForVehicle(idCompany, idVehicle);
		List<VehicleDamageReportDTO> lis = vehicleDTO.getLsitVehicleDamageReport();
		for(VehicleDamageReportDTO damageReportDTO: lis) {
			System.out.println(damageReportDTO.getId());
		}
		for(VehicleDamageReportDTO damageReportDTO : vehicleDTO.getLsitVehicleDamageReport()) {
 			if(damageReportDTO.getId() == idDamageReport) {
 				return damageReportDTO;
 			}
         }
		return null;
	}



}
