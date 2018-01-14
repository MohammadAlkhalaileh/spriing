package com.websystique.springmvc.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.websystique.springmvc.model.Address;

@Repository("addressRepo")
public interface AddressRepo extends CrudRepository<Address, Integer>{

}
