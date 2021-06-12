package com.firmavp.mapper;

import java.util.List;
import java.util.Set;

import com.firmavp.dto.StaffDTO;
import  com.firmavp.entity.Staff;


public interface StaffMapper {
	
	//public ZaposleniDTO vratiListuZaposlenih(Zaposleni zaposleni);
	public void readDataAndCreateMap(List<Staff> zaposleni);
	public StaffDTO getRoot();
	public void buildHierarchyTree(StaffDTO root);
	public List<StaffDTO> getEmployee();
	public StaffDTO toStaffDTO(Staff staff);
	public Staff toStaff(StaffDTO staffDTO);

}
