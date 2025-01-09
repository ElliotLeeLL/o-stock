package com.elliotlee.organization.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Organization
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 2024-10-23 8:48 PM
 */

@Data
@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    @Column(name = "organization_id", nullable = false)
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "contact_name", nullable = false)
    private String contactName;
    @Column(name = "contact_email", nullable = false)
    private String contactEmail;
    @Column(name = "contact_phone", nullable = false)
    private String contactPhone;
}
