package com.firmavp.fasada;

import com.firmavp.dto.StaffDTO;

public interface StaffFacade {
	StaffDTO save(StaffDTO staffDTO,Integer idCompany,Integer idWorkplace,Integer idPlace);

}
