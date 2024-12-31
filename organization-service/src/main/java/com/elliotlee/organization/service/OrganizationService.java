package com.elliotlee.organization.service;

import com.elliotlee.organization.model.Organization;

/**
 * @ClassName OrganizationService
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 12/16/2024 7:38 PM
 **/

public interface OrganizationService {
    public Organization findById(String organizationId);
    public Organization create(Organization organization);
    public void update(Organization organization);
    public void delete(Organization organization);
}
