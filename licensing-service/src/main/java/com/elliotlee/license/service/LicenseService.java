package com.elliotlee.license.service;

import com.elliotlee.license.model.License;
import com.elliotlee.license.model.Organization;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName LicenseService
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 12/16/2024 7:38 PM
 **/

public interface LicenseService {
    public License getLicense(String licenseId);
    public License createLicense(License license);
    public License updateLicense(License license);
    public String deleteLicense(String licenseId);
    public Organization getOrganizationById(String organizationId);
    public List<License> getLicenseByOrganizationId(String organizationId) throws TimeoutException;
}
