package com.firmavp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

	Company findCompanyById(Integer id);

	
}
