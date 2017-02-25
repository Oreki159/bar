package com.dbs.bar.starter.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySources({
	@PropertySource(value = "classpath:config-default.properties"),
	@PropertySource(value = "file:config-default.properties", ignoreResourceNotFound = true)
})
@EnableJpaRepositories(basePackages = "com.dbs.bar.repository")
@EnableTransactionManagement
@ComponentScan(basePackages = {
		"com.dbs.bar.dao",
		"com.dbs.bar.service",
		"com.dbs.bar.rest"
})
public class BarConfiguration {

	private static final String	APP_DRIVER_CLASS_NAME	= "APP_DRIVER_CLASS_NAME";

	private static final String	APP_URL					= "APP_URL";

	private static final String	APP_USERNAME			= "APP_USERNAME";

	private static final String	APP_PASSWORD			= "APP_PASSWORD";

	@Value("${com.dbs.bar.starter.config.driverClassName}")
	private String				driverClassName;

	@Value("${com.dbs.bar.starter.config.url}")
	private String				url;

	@Value("${com.dbs.bar.starter.config.username}")
	private String				username;

	@Value("${com.dbs.bar.starter.config.password}")
	private String				password;

	@Autowired
	private Environment			environment;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty(APP_DRIVER_CLASS_NAME, driverClassName));
		dataSource.setUrl(environment.getProperty(APP_URL, url));
		dataSource.setUsername(environment.getProperty(APP_USERNAME, username));
		dataSource.setPassword(environment.getProperty(APP_PASSWORD, password));
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		return entityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

}
