package com.hcl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.demo.entity.Address;
import com.hcl.demo.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Transactional
	public Address addAddressToo(Address address) {
		
		return addressRepository.save(address);
	}

}
