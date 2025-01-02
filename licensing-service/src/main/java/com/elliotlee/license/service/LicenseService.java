package com.elliotlee.license.service;

import com.elliotlee.license.model.License;
import com.elliotlee.license.model.Organization;

/**
 * @ClassName LicenseService
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 12/16/2024 7:38 PM
 **/

public interface LicenseService {
    public License getLicense(String licenseId, String organizationId);
    public License createLicense(License license);
    public License updateLicense(License license);
    public String deleteLicense(String licenseId);
    public Organization getOrganizationById(String organizationId);
}
