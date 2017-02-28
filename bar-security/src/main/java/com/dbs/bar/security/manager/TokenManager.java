package com.dbs.bar.security.manager;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.dbs.bar.dto.CustomerDto;
import com.dbs.bar.security.manager.exception.TokenManagerException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TokenManager {

	private static final String	SECRET	= "b7f5fd0c3d2569e";

	private static final String	TOKEN	= "token";

	@Autowired
	private ObjectMapper		objectMapper;

	public String generateToken(CustomerDto customerLogged) {
		try {
			Map<String, Object> claims = new HashMap<>();
			claims.put(TOKEN, objectMapper.writeValueAsString(customerLogged));
			return new JWTSigner(SECRET).sign(claims);

		} catch (JsonProcessingException e) {
			throw new TokenManagerException(e);
		}
	}

	public CustomerDto parseToken(String token) {
		try {
			Map<String, Object> claims = new JWTVerifier(SECRET).verify(token);
			return objectMapper.readValue((String) claims.get(TOKEN), CustomerDto.class);

		} catch (InvalidKeyException | NoSuchAlgorithmException | IllegalStateException | SignatureException | IOException | JWTVerifyException e) {
			throw new TokenManagerException(e);

		}
	}

}
