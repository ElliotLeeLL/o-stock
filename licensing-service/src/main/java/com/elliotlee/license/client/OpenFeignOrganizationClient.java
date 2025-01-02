package com.elliotlee.license.client;

import com.elliotlee.license.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName OpenFeignOrganizationClient
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 1/2/2025 9:12 PM
 */
@FeignClient("organization-service")
public interface OpenFeignOrganizationClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/organization/{organizationId}")
    Organization getOrganization(@PathVariable("organizationId") String organizationId);
}
