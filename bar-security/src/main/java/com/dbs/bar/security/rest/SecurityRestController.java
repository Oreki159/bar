package com.dbs.bar.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.bar.dto.CustomerDto;
import com.dbs.bar.security.manager.SecurityManager;
import com.dbs.bar.service.ICustomerService;

@RestController
public class SecurityRestController {

	private static final String	URL_LOGIN		= "/app/security/api/login";

	@Autowired
	private ICustomerService	customerService;

	@Autowired
	private SecurityManager		securityManager;

	@RequestMapping(path = URL_LOGIN, method = RequestMethod.POST)
	public void login(@RequestBody CustomerDto customerDto) {
		CustomerDto customerLogged = customerService.login(customerDto);
		if (customerLogged != null) {
			securityManager.successfulAuthentication(customerLogged);
		} else {
			securityManager.unsuccessfulAuthentication();
		}
	}

}
