package com.elliotlee.license;

import com.elliotlee.license.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ServiceConfig.class)
public class LicenseServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(LicenseServiceApplication.class, args);
	}
}

