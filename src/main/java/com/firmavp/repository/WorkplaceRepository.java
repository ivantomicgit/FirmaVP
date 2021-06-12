package com.firmavp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.Staff;
import com.firmavp.entity.Workplace;
@Repository
public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {

	Workplace findWorkplaceById(Integer id);
	
	//@Query(nativeQuery = true, value = "select s.* from staff as s, workplace as w where s.workplace_id=w.id and w.workplace_name like %:name%")
//	List<Staff> findStaffByWorkplace(@Param("name") String name, Pageable pageable);

}
