package com.dbs.bar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.bar.dao.ICustomerDao;
import com.dbs.bar.dto.CustomerDto;
import com.dbs.bar.service.ICustomerService;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;

	@Override
	public void create(CustomerDto customerDto) {
		customerDao.create(customerDto);
	}

	@Override
	public void update(CustomerDto customerDto) {
		customerDao.update(customerDto);
	}

	@Override
	public void delete(CustomerDto customerDto) {
		customerDao.delete(customerDto);
	}

	@Override
	public CustomerDto login(CustomerDto customerDto) {
		return customerDao.login(customerDto);
	}

	@Override
	public List<CustomerDto> findAll() {
		return customerDao.findAll();
	}

}
