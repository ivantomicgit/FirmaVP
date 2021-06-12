package com.firmavp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

	Staff findStaffById(Integer id);
	
	@Query(nativeQuery = true, value = "select s.* from staff as s, workplace as w where s.workplace_id=w.id and w.workplace_name like %?%")
	List<Staff> findStaffByWorkplace(String workplace_name, Pageable pageable);


	Staff findStaffByUsername(String username);

}
