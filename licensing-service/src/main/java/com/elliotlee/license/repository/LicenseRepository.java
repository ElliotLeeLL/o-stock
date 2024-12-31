package com.elliotlee.license.repository;

import com.elliotlee.license.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @ClassName LicenseRepository
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 2024-12-16 7:20 PM
 */
@Repository
public interface LicenseRepository extends CrudRepository<License, String> {
    public List<License> findByOrganizationId(String organizationId);

    public License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);
}
