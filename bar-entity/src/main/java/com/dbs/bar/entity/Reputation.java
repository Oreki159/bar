package com.dbs.bar.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the reputations database table.
 * 
 */
@Entity
@Table(name = "reputations")
public class Reputation implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REPUTATION_ID")
	private Integer				reputationId;

	private String				comments;

	private BigDecimal			reputation;

	private Integer				state;

	@Column(name = "BAR_ID")
	private Integer				barId;

	@Column(name = "CUSTOMER_ID")
	private Integer				customerId;

	public Reputation() {}

	public Integer getReputationId() {
		return reputationId;
	}

	public void setReputationId(Integer reputationId) {
		this.reputationId = reputationId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BigDecimal getReputation() {
		return reputation;
	}

	public void setReputation(BigDecimal reputation) {
		this.reputation = reputation;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getBarId() {
		return barId;
	}

	public void setBarId(Integer barId) {
		this.barId = barId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}
