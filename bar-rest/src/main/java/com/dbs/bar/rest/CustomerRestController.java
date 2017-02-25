package com.dbs.bar.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dbs.bar.dto.CustomerDto;
import com.dbs.bar.service.ICustomerService;

@RestController
@RequestMapping(path = "/app")
public class CustomerRestController {

	private static final String	TOKEN	= "d0f8f007";
	
	@Autowired
	private ICustomerService	customerService;

	@RequestMapping(path = "/customer/create", method = RequestMethod.POST)
	public void create(@RequestBody CustomerDto customerDto) {
		customerService.create(customerDto);
	}

	@RequestMapping(path = "/customer/update", method = RequestMethod.PUT)
	public void update(@RequestBody CustomerDto customerDto) {
		customerService.update(customerDto);
	}

	@RequestMapping(path = "/customer/delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody CustomerDto customerDto) {
		customerService.delete(customerDto);
	}

	@RequestMapping(path = "security/api/login", method = RequestMethod.POST)
	public void login(CustomerDto customerDto) {
		CustomerDto customerLogged = customerService.login(customerDto);
		if (customerLogged != null) {
			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse().setHeader(TOKEN, UUID.randomUUID().toString());
		}
	}

	@RequestMapping(path = "/customer/findAll", method = RequestMethod.GET)
	public List<CustomerDto> findAll() {
		return customerService.findAll();
	}

}
