package com.dbs.bar.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	private static final String	AUTH_TOKEN	= "d0f8f007";

	private static final String	URL_LOGIN	= "/app/security/api/login";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String authToken = request.getHeader(AUTH_TOKEN);

		if ((authToken == null && URL_LOGIN.equals(request.getRequestURI())) || (authToken != null && !URL_LOGIN.equals(request.getRequestURI()))) {
			response.addHeader(AUTH_TOKEN, authToken);
			filterChain.doFilter(request, response);
			
		} else {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			
		}
	}

}
