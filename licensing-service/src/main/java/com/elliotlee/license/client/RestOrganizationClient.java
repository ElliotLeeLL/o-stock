package com.elliotlee.license.client;

import com.elliotlee.license.model.Organization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @ClassName RestOrganizationClient
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 1/2/2025 8:10 PM
 */

@Slf4j
@Component
public class RestOrganizationClient {
    private final RestTemplate restTemplate;

    public RestOrganizationClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Organization getOrganization(String organizationId) {
        ResponseEntity<Organization> restExchange =  restTemplate.exchange(
                "http://organization-service/v1/organization/{organizationId}",
                HttpMethod.GET,
                null,
                Organization.class,
                organizationId
        );

        log.info("The status code of endpoint getOrganization: {}", restExchange.getStatusCodeValue());
        log.info("The body of endpoint getOrganization: {}", Objects.requireNonNull(restExchange.getBody()));

        return restExchange.getBody();
    }
}
