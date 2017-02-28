package com.dbs.bar.rest;

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
public class LoginRestController {

	private static final String	AUTH_TOKEN	= "d0f8f007";

	@Autowired
	private ICustomerService	customerService;

	@RequestMapping(path = "security/api/login", method = RequestMethod.POST)
	public void login(@RequestBody CustomerDto customerDto) {
		CustomerDto customerLogged = customerService.login(customerDto);
		if (customerLogged != null) {
			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse().setHeader(AUTH_TOKEN, UUID.randomUUID().toString());
		}
	}
	
}
