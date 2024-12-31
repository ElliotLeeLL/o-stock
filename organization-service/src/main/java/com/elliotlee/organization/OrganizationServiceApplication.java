package com.elliotlee.organization;

import com.elliotlee.organization.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ServiceConfig.class)
public class OrganizationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}
}

