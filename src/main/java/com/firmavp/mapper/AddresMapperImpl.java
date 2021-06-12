package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.firmavp.dto.AddressDTO;
import com.firmavp.entity.Address;

@Component
public class AddresMapperImpl implements AddressMapper {

	@Override
	public AddressDTO toAddressDTO(Address address) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setId(address.getId());
		addressDTO.setCity(address.getCity());
		addressDTO.setStreet(address.getStreet());
		addressDTO.setPostalCode(address.getPostalCode());		
		return addressDTO;
	}

	@Override
	public List<AddressDTO> toListAddressDTO(List<Address> listAddress) {
		List<AddressDTO> listDTO = new ArrayList<AddressDTO>();
		for(Address a : listAddress) {
			AddressDTO aDTO = new AddressDTO();
			aDTO.setId(a.getId());
			aDTO.setCity(a.getCity());
			aDTO.setStreet(a.getStreet());
			aDTO.setPostalCode(a.getPostalCode());
			listDTO.add(aDTO);
		}
		return listDTO;
	}

	@Override
	public Address toAddress(AddressDTO addressDTO) {
		Address address = new Address();
		address.setId(addressDTO.getId());
		address.setCity(addressDTO.getCity());
		address.setStreet(addressDTO.getStreet());
		address.setPostalCode(addressDTO.getPostalCode());
		
		return address;
	}

}
