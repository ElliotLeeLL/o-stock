package com.elliotlee.license.service;

import com.elliotlee.license.model.License;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @ClassName LicenseService
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 2024-10-23 8:51 PM
 */
@Service
public class LicenseService {
    public License getLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(2000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");
        return license;
    }

    public String createLicense(License license, String organizationId) {
        String responseMessage = null;
        if(license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = "Add a new license: " + license;
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if(license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = "Update a license: " + license;
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        return String
                .format(
                        "Delete a license with licenseId %s and organizationId %s",
                        licenseId,
                        organizationId
                );
    }
}
