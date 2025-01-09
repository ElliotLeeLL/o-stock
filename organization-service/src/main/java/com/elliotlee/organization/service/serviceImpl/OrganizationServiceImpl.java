package com.elliotlee.organization.service.serviceImpl;

import com.elliotlee.organization.config.ServiceConfig;
import com.elliotlee.organization.model.Organization;
import com.elliotlee.organization.repository.OrganizationRepository;
import com.elliotlee.organization.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @ClassName OrganizationServiceImpl
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 2024-10-23 8:51 PM
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository repository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.repository = organizationRepository;
    }
    @Override
    public Organization findById(String organizationId) {
        return repository.findById(organizationId).orElse(null);
    }

    @Override
    public Organization create(Organization organization) {
        organization.setId(UUID.randomUUID().toString());
        organization = repository.save(organization);
        return organization;
    }

    @Override
    public void update(Organization organization) {
        repository.save(organization);
    }

    @Override
    public void delete(Organization organization) {
        repository.deleteById(organization.getId());
    }
}
