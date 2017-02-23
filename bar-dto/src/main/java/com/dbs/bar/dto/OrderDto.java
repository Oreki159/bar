package com.dbs.bar.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderDto implements Serializable {

	private static final long		serialVersionUID	= 1L;

	private Integer					orderId;

	private Date					orderDate;

	private String					qrcode;

	private Integer					state;

	private List<OrderDetailDto>	orderDetails;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<OrderDetailDto> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailDto> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
