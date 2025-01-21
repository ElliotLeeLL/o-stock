package com.elliotlee.license.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserContext
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 1/21/2025 8:50 PM
 */
@Component
@Data
public class UserContext {
    public static final String CORRELATION_ID = "tmx-correlation-id";
    public static final String USER_ID = "tmx-user-id";
    public static final String AUTH_TOKEN = "tmx-auth-token";
    public static final String ORGANIZATION_ID = "tmx-organization-id";

    private String correlationId = "";
    private String userId = "";
    private String authToken = "";
    private String organizationId = "";
}
