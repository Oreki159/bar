package com.dbs.bar.security.manager;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.dbs.bar.dto.CustomerDto;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Component
public class TokenManager {

	private static final String	SECRET	= "b7f5fd0c3d2569e";

	private static final String	TOKEN	= "token";

	public String generateToken(CustomerDto customerLogged) {
		try {
			Map<String, Object> claims = new HashMap<>();
			claims.put(TOKEN, getObjectMapper().writeValueAsString(customerLogged));
			return new JWTSigner(SECRET).sign(claims);

		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public CustomerDto parseToken(String token) {
		try {
			Map<String, Object> claims = new JWTVerifier(SECRET).verify(token);
			return getObjectMapper().readValue((String) claims.get(TOKEN), CustomerDto.class);

		} catch (InvalidKeyException | NoSuchAlgorithmException | IllegalStateException | SignatureException | IOException | JWTVerifyException e) {
			throw new RuntimeException(e);

		}
	}

	private ObjectMapper getObjectMapper() {
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.registerModule(new JodaModule());
		objectMapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		return objectMapper;
	}

}
