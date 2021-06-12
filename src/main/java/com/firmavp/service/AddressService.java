package com.firmavp.service;

import java.util.List;

import com.firmavp.dto.AddressDTO;
import com.firmavp.entity.Address;

public interface AddressService {

	Address save(Address address);

	Address findAddressById(Integer id);

	List<Address> findAll();

	AddressDTO update(Integer id, AddressDTO addressDTO);

	void delete(Integer id);

}
