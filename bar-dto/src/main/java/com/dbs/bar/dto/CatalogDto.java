package com.dbs.bar.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CatalogDto implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Integer				catalogId;

	private LocalDate			finalDate;

	private LocalDate			startDate;

	private Integer				state;

	private BigDecimal			unitPrice;

	private Integer				barId;

	private Integer				productId;

	private ProductDto			product;

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public LocalDate getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getBarId() {
		return barId;
	}

	public void setBarId(Integer barId) {
		this.barId = barId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

}
