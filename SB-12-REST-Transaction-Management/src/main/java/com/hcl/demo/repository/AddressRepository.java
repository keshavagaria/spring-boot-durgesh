package com.hcl.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.hcl.demo.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>{

}
