package com.elliotlee.license.controller;

import com.elliotlee.license.model.License;
import com.elliotlee.license.service.LicenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        License license = licenseService.getLicense(licenseId, organizationId);
        return ResponseEntity.ok(license);
    }

    @PostMapping
    public ResponseEntity<String> createLicense(
            @RequestBody License license,
            @PathVariable String organizationId
            ) {
        String message = licenseService.createLicense(license, organizationId);
        return ResponseEntity.ok(message);
    }

    @PutMapping
    public ResponseEntity<String> updateLicense(
            @RequestBody License license,
            @PathVariable String organizationId
    ) {
        String message = licenseService.updateLicense(license, organizationId);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping(value = "/{licenseId}")
    public ResponseEntity<String> deleteLicense(
            @PathVariable String licenseId,
            @PathVariable String organizationId
    ) {
        String message = licenseService.deleteLicense(licenseId, organizationId);
        return ResponseEntity.ok(message);
    }

}
