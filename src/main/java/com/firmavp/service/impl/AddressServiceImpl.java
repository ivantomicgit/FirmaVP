package com.firmavp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmavp.dto.AddressDTO;
import com.firmavp.entity.Address;
import com.firmavp.entity.Company;
import com.firmavp.exception.ApiErrorResponse;
import com.firmavp.mapper.AddressMapper;
import com.firmavp.repository.AddressRepository;
import com.firmavp.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;
	private final AddressMapper addressMapper;

	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
		super();
		this.addressRepository = addressRepository;
		this.addressMapper = addressMapper;
	}

	@Override
	@Transactional
	public Address save(Address adresa) {
		// TODO Auto-generated method stub
		return addressRepository.save(adresa);
	}

	@Override
	@Transactional(readOnly = true)
	public Address findAddressById(Integer id) {
		Address address = addressRepository.findAddressById(id);

		if (address == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no address for id " + id)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		return address;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Address> findAll() {

		return addressRepository.findAll();
	}

	@Override
	@Transactional
	public AddressDTO update(Integer id, AddressDTO adresaDTO) {

		Address address = addressMapper.toAddress(adresaDTO);
		address.setId(id);
		Address addressvFromDatabase = addressRepository.findAddressById(id);

		if (addressvFromDatabase == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no address for id " + id)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		

		return addressMapper.toAddressDTO(addressRepository.save(address));
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Address adresaIzBaze = addressRepository.findAddressById(id);
		if (adresaIzBaze == null) {
			throw new ApiErrorResponse.ApiErrorResponseBuilder().withMessage("no address for id " + id)
					.withError_code("NOT_FOUND").withStatus(HttpStatus.NOT_FOUND).build();
		}
		addressRepository.deleteById(id);
	}

}
