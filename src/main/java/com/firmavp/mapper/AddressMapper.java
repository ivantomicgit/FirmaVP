package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.AddressDTO;
import com.firmavp.entity.Address;

public interface AddressMapper {

	AddressDTO toAddressDTO(Address address);

	List<AddressDTO> toListAddressDTO(List<Address> listAddress);

	Address toAddress(AddressDTO addressDTO);

}
