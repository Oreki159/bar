package com.dbs.bar.dao;

import java.util.List;

import com.dbs.bar.dto.CustomerDto;

public interface ICustomerDao {

	void create(CustomerDto customerDto);

	void update(CustomerDto customerDto);

	void delete(CustomerDto customerDto);
	
	CustomerDto login(CustomerDto customerDto);

	List<CustomerDto> findAll();

}
