package com.elliotlee.license.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName LicenseService
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 2024-12-16 7:20 PM
 */
@Configuration
@ConfigurationProperties(prefix = "example")
public class ServiceConfig {
    private String property;

    public String getProperty() {
        return property;
    }
}
