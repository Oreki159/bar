package com.dbs.bar.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class OrderDto implements Serializable {

	private static final long		serialVersionUID	= 1L;

	private Integer					orderId;

	private Integer					customerId;

	private LocalDate				orderDate;

	private String					qrCode;

	private Integer					state;

	private List<OrderDetailDto>	orderDetails;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
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
