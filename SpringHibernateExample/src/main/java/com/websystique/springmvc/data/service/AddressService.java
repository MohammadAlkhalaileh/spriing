package com.websystique.springmvc.data.service;

import java.util.List;

import com.websystique.springmvc.model.Address;

public interface AddressService {

	Address findById(int id);

	void saveAddress(Address address);

	void updateAddress(Address address);

	void deleteAddressById(int id);

	List<Address> findAllAddresses();
}
