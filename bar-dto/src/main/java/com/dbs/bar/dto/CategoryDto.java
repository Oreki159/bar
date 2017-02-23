package com.dbs.bar.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Integer				categoryId;

	private String				categoryName;

	private Integer				state;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
