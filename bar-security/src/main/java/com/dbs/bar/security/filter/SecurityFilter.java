package com.dbs.bar.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dbs.bar.security.manager.SecurityManager;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private SecurityManager securityManager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if (securityManager.requiresAuthentication(request.getMethod(), request.getRequestURI())) {
			if (securityManager.isFullyAuthenticated(request, response)) {
				filterChain.doFilter(request, response);
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}

}
