package com.elliotlee.license.service.serviceImpl;

import com.elliotlee.license.config.ServiceConfig;
import com.elliotlee.license.model.License;
import com.elliotlee.license.repository.LicenseRepository;
import com.elliotlee.license.service.LicenseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @ClassName LicenseService
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 2024-10-23 8:51 PM
 */
@Service
public class LicenseServiceImpl implements LicenseService {
    final private LicenseRepository licenseRepository;
    final private ServiceConfig serviceConfig;
    public LicenseServiceImpl(LicenseRepository licenseRepository, ServiceConfig serviceConfig) {
        this.licenseRepository = licenseRepository;
        this.serviceConfig = serviceConfig;
    }
    public License getLicense(String licenseId, String organizationId) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if(null == license) {
            throw new IllegalArgumentException("License not found");
        }
        return license.withComment(serviceConfig.getProperty());
    }

    public License createLicense(License license) {
        license.setLicenseId(UUID.randomUUID().toString());
        licenseRepository.save(license);
        return license.withComment(serviceConfig.getProperty());
    }

    public License updateLicense(License license) {
        licenseRepository.save(license);
        return license.withComment(serviceConfig.getProperty());
    }

    public String deleteLicense(String licenseId) {
        License license = new License();
        license.setLicenseId(licenseId);
        licenseRepository.delete(license);
        return "License deleted";
    }
}
