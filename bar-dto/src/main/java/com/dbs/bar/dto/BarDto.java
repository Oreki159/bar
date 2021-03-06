package com.dbs.bar.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

public class BarDto implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Integer				barId;

	private String				address;

	private LocalTime			hourClose;

	private LocalTime			hourOpen;

	private BigDecimal			latitude;

	private BigDecimal			longitude;

	private String				name;

	private String				phone;

	private String				image;

	private Integer				state;

	public Integer getBarId() {
		return barId;
	}

	public void setBarId(Integer barId) {
		this.barId = barId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalTime getHourClose() {
		return hourClose;
	}

	public void setHourClose(LocalTime hourClose) {
		this.hourClose = hourClose;
	}

	public LocalTime getHourOpen() {
		return hourOpen;
	}

	public void setHourOpen(LocalTime hourOpen) {
		this.hourOpen = hourOpen;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
