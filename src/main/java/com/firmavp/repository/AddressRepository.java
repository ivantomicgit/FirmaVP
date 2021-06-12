package com.firmavp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

	Address findAddressById(Integer id);

	
}
