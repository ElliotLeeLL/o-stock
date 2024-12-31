package com.elliotlee.organization.controller;

import com.elliotlee.organization.model.Organization;
import com.elliotlee.organization.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName OrganizationController
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 2024-10-23 8:45 PM
 */

@RestController
@RequestMapping(value = "v1/organization")
public class OrganizationController {
    final OrganizationService service;
    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @GetMapping("/{organizationId}")
    public ResponseEntity<Organization> getOrganization(
            @PathVariable String organizationId) {
        return ResponseEntity.ok(service.findById(organizationId));
    }

    @PutMapping("/{organizationId}")
    public void updateOrganization(
            @RequestBody Organization organization,
            @PathVariable String organizationId
    ) {
        service.update(organization);
    }

    @PostMapping
    public ResponseEntity<Organization> createOrganization(
            @RequestBody Organization organization
    ) {
        return ResponseEntity.ok(service.create(organization));
    }

    @DeleteMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(            @RequestBody Organization organization,
                                               @PathVariable String organizationId) {
        service.delete(organization);
    }
}
