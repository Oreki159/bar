package com.dbs.bar.service;

import java.util.List;

import com.dbs.bar.dto.CustomerDto;

public interface ICustomerService {

	void create(CustomerDto customerDto);

	void update(CustomerDto customerDto);

	void delete(CustomerDto customerDto);

	List<CustomerDto> findAll();
	
}
