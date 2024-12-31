package com.elliotlee.organization.repository;

import com.elliotlee.organization.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName OrganizationRepository
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 2024-12-16 7:20 PM
 */
@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
    public Optional<Organization> findById(String organizationId);
}
