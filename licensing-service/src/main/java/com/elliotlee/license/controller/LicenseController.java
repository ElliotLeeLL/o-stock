package com.elliotlee.license.controller;

import com.elliotlee.license.model.License;
import com.elliotlee.license.model.Organization;
import com.elliotlee.license.service.LicenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LicenseController
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 2024-10-23 8:45 PM
 */

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/license")
public class LicenseController {
    final LicenseService licenseService;
    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping(value = "/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable String licenseId,
                                              @PathVariable String organizationId) {
        License license = licenseService.getLicense(licenseId);
        return ResponseEntity.ok(license);
    }

    @PostMapping
    public ResponseEntity<License> createLicense(
            @RequestBody License license,
            @PathVariable String organizationId
            ) {
        License res = licenseService.createLicense(license);
        return ResponseEntity.ok(res);
    }

    @PutMapping
    public ResponseEntity<License> updateLicense(
            @RequestBody License license,
            @PathVariable String organizationId
    ) {
        License res = licenseService.updateLicense(license);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping(value = "/{licenseId}")
    public ResponseEntity<String> deleteLicense(
            @PathVariable String licenseId,
            @PathVariable String organizationId
    ) {
        String message = licenseService.deleteLicense(licenseId);
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity<Organization> getOrganizationById(
            @PathVariable String organizationId
    ) {
        return ResponseEntity.ok(licenseService.getOrganizationById(organizationId));
    }

}
