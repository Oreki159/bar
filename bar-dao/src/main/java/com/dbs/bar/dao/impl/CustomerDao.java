package com.dbs.bar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.dbs.bar.dao.ICustomerDao;
import com.dbs.bar.dto.CustomerDto;
import com.dbs.bar.entity.Customer;
import com.dbs.bar.repository.CustomerRepository;

@Repository
public class CustomerDao implements ICustomerDao {

	@Resource
	private CustomerRepository customerRepository;

	@Override
	public void create(CustomerDto customerDto) {
		customerRepository.save(parseDtoToEntity(customerDto));
	}

	@Override
	public void update(CustomerDto customerDto) {
		customerRepository.save(parseDtoToEntity(customerDto));
	}

	@Override
	public void delete(CustomerDto customerDto) {
		customerRepository.delete(customerDto.getCustomerId());
	}

	@Override
	public List<CustomerDto> findAll() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDto> customersDto = new ArrayList<>(0);
		for (Customer customer : customers) {
			customersDto.add(parseEntityToDto(customer));
		}
		return customersDto;
	}

	private CustomerDto parseEntityToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		BeanUtils.copyProperties(customer, customerDto);
		return customerDto;
	}

	private Customer parseDtoToEntity(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		return customer;
	}

}
