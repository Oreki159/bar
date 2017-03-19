package com.dbs.bar.dao.impl;

import static java.time.Instant.ofEpochMilli;
import static java.time.LocalDateTime.ofInstant;
import static java.time.ZoneId.systemDefault;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.dbs.bar.dao.ICustomerDao;
import com.dbs.bar.dao.constant.DaoConstant;
import com.dbs.bar.dto.CustomerDto;
import com.dbs.bar.entity.Customer;
import com.dbs.bar.repository.CustomerRepository;

@Repository
public class CustomerDao implements ICustomerDao {

	@Resource
	private CustomerRepository		customerRepository;

	@Override
	public void create(CustomerDto customerDto) {
		customerDto.setState(DaoConstant.ENABLE);
		customerRepository.save(parseDtoToEntity(customerDto));
	}

	@Override
	public void update(CustomerDto customerDto) {
		customerRepository.save(parseDtoToEntity(customerDto));
	}

	@Override
	public void delete(CustomerDto customerDto) {
		Customer customer = customerRepository.findOne(customerDto.getCustomerId());
		customer.setState(DaoConstant.DISABLE);
		customerRepository.save(customer);
	}

	@Override
	public CustomerDto login(CustomerDto customerDto) {
		return parseEntityToDto(customerRepository.findByEmailAndPass(customerDto.getEmail(), customerDto.getPass()));
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
		if (customer != null) {
			CustomerDto customerDto = new CustomerDto();
			BeanUtils.copyProperties(customer, customerDto);

			customerDto.setBirthDate(customer.getBirthDate() == null ? null : ofInstant(ofEpochMilli(customer.getBirthDate().getTime()), systemDefault()).toLocalDate());
			return customerDto;
		}
		return null;
	}

	private Customer parseDtoToEntity(CustomerDto customerDto) {
		if (customerDto != null) {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerDto, customer);
			customer.setBirthDate(customerDto.getBirthDate() == null ? null : Date.from(customerDto.getBirthDate().atStartOfDay(systemDefault()).toInstant()));
			return customer;
		}
		return null;
	}

}
