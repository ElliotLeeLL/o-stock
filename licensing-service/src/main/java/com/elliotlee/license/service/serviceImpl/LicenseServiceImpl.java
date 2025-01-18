package com.elliotlee.license.service.serviceImpl;

import com.elliotlee.license.client.OpenFeignOrganizationClient;
import com.elliotlee.license.client.RestOrganizationClient;
import com.elliotlee.license.config.ServiceConfig;
import com.elliotlee.license.model.License;
import com.elliotlee.license.model.Organization;
import com.elliotlee.license.repository.LicenseRepository;
import com.elliotlee.license.service.LicenseService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import static java.lang.Thread.sleep;

/**
 * @ClassName LicenseServiceImpl
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 2024-10-23 8:51 PM
 */
@Slf4j
@Service
public class LicenseServiceImpl implements LicenseService {
    final private LicenseRepository licenseRepository;
    final private ServiceConfig serviceConfig;
    final private RestOrganizationClient restOrganizationClient;
    final private OpenFeignOrganizationClient openFeignOrganizationClient;
    public LicenseServiceImpl(LicenseRepository licenseRepository, ServiceConfig serviceConfig, RestOrganizationClient restOrganizationClient, OpenFeignOrganizationClient openFeignOrganizationClient) {
        this.licenseRepository = licenseRepository;
        this.serviceConfig = serviceConfig;
        this.restOrganizationClient = restOrganizationClient;
        this.openFeignOrganizationClient = openFeignOrganizationClient;
    }
    public License getLicense(String licenseId) {
        License license = licenseRepository.findLicenseByLicenseId(licenseId);
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


    public Organization getOrganizationById(String organizationId){
        Organization restOrg1 = restOrganizationClient.getOrganization(organizationId);
        System.out.println(restOrg1);
        Organization openOrg2 = openFeignOrganizationClient.getOrganization(organizationId);
        System.out.println(openOrg2);
        return openFeignOrganizationClient.getOrganization(organizationId);
    }

    @CircuitBreaker(name = "licenseService", fallbackMethod = "buildFallbackLicenseList")
    @RateLimiter(name = "licenseService", fallbackMethod = "buildFallbackLicenseList")
    @Retry(name = "licenseService", fallbackMethod = "buildFallbackLicenseList")
    @Bulkhead(name = "licenseService", fallbackMethod = "buildFallbackLicenseList")
    public List<License> getLicenseByOrganizationId(String organizationId) throws TimeoutException {
        sleepForRandomTime();
        return licenseRepository.findByOrganizationId(organizationId);
    }

    private void sleepForRandomTime() throws TimeoutException {
        Random random = new Random();
        int randomInt = random.nextInt(4);

        if(randomInt <= 2) {
            try {
                System.out.println("Sleeping");
                Thread.sleep(5000);
                throw new TimeoutException();
            }catch (InterruptedException e) {
                log.error("InterruptedException", e);
            }
        }
    }

    public List<License> buildFallbackLicenseList(String organizationId, Throwable t) {
        List<License> licenseList = new ArrayList<>();
        License license = new License();
        license.setLicenseId("0000000-00-00000");
        license.setOrganizationId(organizationId);
        license.setProductName("Sorry no licensing information currently available");
        licenseList.add(license);

        return licenseList;
    }
}
