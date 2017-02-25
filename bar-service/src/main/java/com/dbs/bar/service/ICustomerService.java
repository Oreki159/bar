package com.dbs.bar.service;

import java.util.List;

import com.dbs.bar.dto.CustomerDto;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
public interface ICustomerService {

	void create(CustomerDto customerDto);

	void update(CustomerDto customerDto);

	void delete(CustomerDto customerDto);

	CustomerDto login(CustomerDto customerDto);

	List<CustomerDto> findAll();

}
