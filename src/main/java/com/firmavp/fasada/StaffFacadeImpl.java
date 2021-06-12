package com.firmavp.fasada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.firmavp.dto.StaffDTO;
import com.firmavp.entity.Address;
import com.firmavp.entity.Company;
import com.firmavp.entity.Place;
import com.firmavp.entity.Workplace;
import com.firmavp.entity.Staff;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.CompanyMapper;
import com.firmavp.mapper.StaffMapper;
import com.firmavp.service.CompanyService;
import com.firmavp.service.PlaceService;
import com.firmavp.service.StaffService;
import com.firmavp.service.WorkplaceService;

@Component
public class StaffFacadeImpl  implements StaffFacade {
	
	private final StaffService staffService;
	private final StaffMapper staffMapper;
	private final CompanyService companyService;
	private final CompanyMapper companyMapper;
	private final WorkplaceService workplaceService;
	private final PlaceService placeService;
	
	
    @Autowired
	public StaffFacadeImpl(StaffService staffService, StaffMapper staffMapper, CompanyService companyService,
			CompanyMapper companyMapper, WorkplaceService workplaceService,PlaceService placeService) {
		super();
		this.staffService = staffService;
		this.staffMapper = staffMapper;
		this.companyService = companyService;
		this.companyMapper = companyMapper;
		this.workplaceService = workplaceService;
		this.placeService=placeService;
	}
    
	public Company getAndCheckCompany(Integer idCompany) {
 		Company  databaseCompany = companyMapper.toCompany(companyService.findCompany(idCompany));
 		if (databaseCompany == null) {
     		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("company does not exist for id " +idCompany).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

 		}
 		return databaseCompany;
	}
	public Workplace getAndCheckWorkplace(Integer idWorkplace) {
		Workplace databaseWorkplace = workplaceService.findWorkplaceById(idWorkplace);
 		if (databaseWorkplace == null) {
     		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("workplace for id does not exist " +idWorkplace).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

 		}
 		return databaseWorkplace;
 	}
	public Place getAndCheckPlace(Integer idPlace) {
		Place databasePlace =placeService.findPlace(idPlace);
 		if (databasePlace == null) {
     		throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("place for id does not exist " +databasePlace).withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();

 		}
 		return databasePlace;
 	}

	@Override
	public StaffDTO save(StaffDTO staffDTO, Integer idCompany, Integer idWorkplace, Integer idPlace) {
		Company company = getAndCheckCompany(idCompany);
		Place place = getAndCheckPlace(idPlace);
		Workplace wokrplace= getAndCheckWorkplace(idWorkplace);
		Staff staff = new Staff();
		staff.setId(staffDTO.getId());
		staff.setFirstNameStaff(staffDTO.getIme());
		staff.setLastNameStaff(staffDTO.getPrezime());
		staff.setSpecialty(staffDTO.getSpecijalnost());
		staff.setCompany(company);
		staff.setPlace(place);
		staff.setWorkplace(wokrplace);
		
		StaffDTO staffDTOSave=staffService.save(staff);
		return staffDTOSave ;
	}

}
