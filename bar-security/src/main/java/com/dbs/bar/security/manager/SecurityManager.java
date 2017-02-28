package com.dbs.bar.security.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dbs.bar.dto.CustomerDto;

@Component
public class SecurityManager {

	private static final String	SECURITY_TOKEN	= "d0f8f007";

	private static final String	URL_LOGIN		= "/app/security/api/login";

	@Autowired
	private TokenManager		tokenManager;

	public boolean requiresAuthentication(String uri) {
		return !URL_LOGIN.equals(uri);
	}

	public void successfulAuthentication(CustomerDto customerLogged) {
		authorize(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse(), customerLogged);
	}

	public void unsuccessfulAuthentication() {
		unauthorize(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse());
	}

	public boolean isFullyAuthenticated(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI();
		String authToken = request.getHeader(SECURITY_TOKEN);

		if ((authToken == null && URL_LOGIN.equals(uri)) || (authToken != null && !URL_LOGIN.equals(uri))) {
			authorize(response, tokenManager.parseToken(authToken));
			return true;

		} else {
			unauthorize(response);
			return false;

		}
	}

	private void unauthorize(HttpServletResponse response) {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
	}

	private void authorize(HttpServletResponse response, CustomerDto customerLogged) {
		response.setHeader(SECURITY_TOKEN, tokenManager.generateToken(customerLogged));
	}

}
