package com.elliotlee.organization.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ServiceConfig
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
