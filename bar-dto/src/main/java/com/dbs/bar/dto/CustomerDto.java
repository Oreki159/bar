package com.dbs.bar.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomerDto implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Integer				customerId;

	private LocalDate			birthDate;

	private String				email;

	private String				pass;

	private Integer				state;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
