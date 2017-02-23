package com.dbs.bar.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the bars database table.
 * 
 */
@Entity
@Table(name = "bars")
public class Bar implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BAR_ID")
	private Integer				barId;

	private String				address;

	@Column(name = "HOUR_CLOSE")
	private Time				hourClose;

	@Column(name = "HOUR_OPEN")
	private Time				hourOpen;

	private BigDecimal			latitude;

	private BigDecimal			longitude;

	private String				name;

	private String				phone;

	private Integer				state;

	public Bar() {}

	public Integer getBarId() {
		return this.barId;
	}

	public void setBarId(Integer barId) {
		this.barId = barId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Time getHourClose() {
		return this.hourClose;
	}

	public void setHourClose(Time hourClose) {
		this.hourClose = hourClose;
	}

	public Time getHourOpen() {
		return this.hourOpen;
	}

	public void setHourOpen(Time hourOpen) {
		this.hourOpen = hourOpen;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
