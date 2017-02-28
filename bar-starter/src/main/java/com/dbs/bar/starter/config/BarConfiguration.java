package com.dbs.bar.starter.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dbs.bar.starter.config.properties.BarDbProperties;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
@Configuration
@EnableConfigurationProperties(value = BarDbProperties.class)
@PropertySources({
	@PropertySource(value = "classpath:config-default.properties"),
	@PropertySource(value = "file:config-default.properties", ignoreResourceNotFound = true)
})
@EnableJpaRepositories(basePackages = "com.dbs.bar.repository")
@EnableTransactionManagement
@ComponentScan(basePackages = {
		"com.dbs.bar.dao",
		"com.dbs.bar.service",
		"com.dbs.bar.rest",
		"com.dbs.bar.security.manager",
		"com.dbs.bar.security.rest",
		"com.dbs.bar.security.filter"
})
public class BarConfiguration {

	private static final String	APP_DRIVER_CLASS_NAME	= "APP_DRIVER_CLASS_NAME";

	private static final String	APP_URL					= "APP_URL";

	private static final String	APP_USERNAME			= "APP_USERNAME";

	private static final String	APP_PASS				= "APP_PASS";

	@Autowired
	private BarDbProperties		barDbProperties;

	@Autowired
	private Environment			environment;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty(APP_DRIVER_CLASS_NAME, barDbProperties.getDriverClassName()));
		dataSource.setUrl(environment.getProperty(APP_URL, barDbProperties.getUrl()));
		dataSource.setUsername(environment.getProperty(APP_USERNAME, barDbProperties.getUsername()));
		dataSource.setPassword(environment.getProperty(APP_PASS, barDbProperties.getPass()));
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

	@Bean
	public ObjectMapper objectMapper() {
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.registerModule(new JodaModule());
		objectMapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		return objectMapper;
	}

	@Bean
	public HttpMessageConverter<?> messageConverter() {
		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper());
		return converter;
	}

}
