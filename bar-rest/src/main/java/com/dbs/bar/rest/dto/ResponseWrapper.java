package com.dbs.bar.rest.dto;

public class ResponseWrapper<T> {

	private String	errorCode;
	private T		response;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

}
