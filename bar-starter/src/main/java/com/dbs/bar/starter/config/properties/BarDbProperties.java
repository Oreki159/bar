package com.dbs.bar.starter.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
@ConfigurationProperties(prefix = "com.dbs.bar.starter.config")
public class BarDbProperties {

	private String	driverClassName;

	private String	url;

	private String	username;

	private String	pass;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
