package com.firmavp.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firmavp.dto.StaffDTO;
import com.firmavp.entity.Staff;
import com.firmavp.exception.ApiErrorResponse;
@Component
public class StaffMapperImpl implements StaffMapper {
//https://www.youtube.com/watch?v=p3Ct3hELjSs
	private final Map<Integer, StaffDTO> employees = new HashMap<Integer, StaffDTO>();
	private  StaffDTO root;
	private final List<StaffDTO> emplList = new ArrayList<StaffDTO>();
	private final AtomicInteger atomicInteger = new AtomicInteger();
	

	public Map<Integer, StaffDTO> getEmployees() {
		return employees;
	}
	
	public StaffDTO getRoot() {
		return root;
	}
	public void setRoot(StaffDTO root) {
		this.root = root;
	}
	
	
	@Override
	public  void readDataAndCreateMap(List<Staff> zaposleni) throws ApiErrorResponse {
	       StaffDTO employee = null; 
			for(Staff temp : zaposleni) { 
				if(temp.getManager() == null) {
				    employee = new StaffDTO(temp.getId(),0, temp.getSpecialty(), temp.getFirstNameStaff(), temp.getLastNameStaff());
				}else {
					employee = new StaffDTO(temp.getId(),temp.getManager().getId(), temp.getSpecialty(), temp.getFirstNameStaff(), temp.getLastNameStaff());
				}
					
				employees.put(employee.getId(), employee);
				if (temp.getManager() == null) root = employee;
				
	        }
			
		
	 }
	 private  List<StaffDTO> getSubordinatesById(int id) {
		 List<StaffDTO> subordinates = new ArrayList<StaffDTO>();
		 for (StaffDTO employee : employees.values()) {
           if (employee.getMenagerId() == id) {
           	subordinates.add(employee);
           }
		 }
		 return subordinates;
	 }
	 	 
	 //build tree recursively
	 public  void buildHierarchyTree(StaffDTO localRoot) {
		StaffDTO employee = localRoot;
		List<StaffDTO> subordinates = getSubordinatesById(employee.getId());
		employee.setEmployee(subordinates);
		emplList.add(employee);
        if (subordinates.size() == 0) {
            return;
        }
 
        for (StaffDTO e : subordinates) {
        	buildHierarchyTree(e);
        }
       
	 }
	@Override
	public List<StaffDTO> getEmployee() {
		// TODO Auto-generated method stub
		return emplList;
	}


	@Override
	public StaffDTO toStaffDTO(Staff staff) {
		StaffDTO staffDTO = new StaffDTO();
	  staffDTO.setId(staff.getId());
	  staffDTO.setIme(staff.getFirstNameStaff());
	  staffDTO.setPrezime(staff.getLastNameStaff());
	  staffDTO.setSpecijalnost(staff.getSpecialty());
	  
		
		return staffDTO;
	}

	@Override
	public Staff toStaff(StaffDTO staffDTO) {
		Staff staff = new Staff();
		staff.setId(staffDTO.getId());
		staff.setFirstNameStaff(staffDTO.getIme());
		staff.setLastNameStaff(staffDTO.getPrezime());
		staff.setSpecialty(staffDTO.getSpecijalnost());
		return staff;
	}

	
	
	 
}
