package com.dbs.bar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.bar.dto.CustomerDto;
import com.dbs.bar.service.ICustomerService;

@RestController
@RequestMapping(path = "/app/customer")
public class CustomerRestController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public void create(@RequestBody CustomerDto customerDto) {
		customerService.create(customerDto);
	}

	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody CustomerDto customerDto) {
		customerService.update(customerDto);
	}

	@RequestMapping(path = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody CustomerDto customerDto) {
		customerService.create(customerDto);
	}

	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	public List<CustomerDto> findAll() {
		return customerService.findAll();
	}

}
