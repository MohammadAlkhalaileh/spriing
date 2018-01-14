package com.websystique.springmvc.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.data.repo.AddressRepo;
import com.websystique.springmvc.model.Address;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	@Qualifier("addressRepo")
	private AddressRepo addressRepo;

	@Override
	public Address findById(int id) {
		return addressRepo.findOne(id);
	}

	@Override
	public void saveAddress(Address address) {
		addressRepo.save(address);
	}

	@Override
	public void updateAddress(Address address) {
		addressRepo.save(address);
	}

	@Override
	public void deleteAddressById(int id) {
		addressRepo.delete(id);
	}

	@Override
	public List<Address> findAllAddresses() {
		return (List<Address>) addressRepo.findAll();
	}

}
