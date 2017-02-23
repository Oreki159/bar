package com.dbs.bar.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dbs.bar.starter.config.BarConfiguration;

@SpringBootApplication(scanBasePackageClasses = {BarConfiguration.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
