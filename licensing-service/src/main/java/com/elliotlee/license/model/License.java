package com.elliotlee.license.model;

import lombok.Data;

/**
 * @ClassName License
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 2024-10-23 8:48 PM
 */
@Data
public class License {
    private int id;
    private String licenseId;
    private String description;
    private String organizationId;
    private String productName;
    private String licenseType;
}
