package com.ascent.payroll_calendar.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "service_catalog")
@Data
public class ServiceCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "catalog_id", nullable = false, updatable = false)
    private UUID catalogId;

    @Column(name = "catalog_name", nullable = false)
    private String catalogName;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_dt", nullable = false, updatable = false)
    private Date createdDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_dt", nullable = false)
    private Date updatedDt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;
}