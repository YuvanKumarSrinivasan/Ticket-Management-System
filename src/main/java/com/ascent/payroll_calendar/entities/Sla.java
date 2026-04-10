package com.ascent.payroll_calendar.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

import com.ascent.payroll_calendar.utils.enums.TicketType;
import com.ascent.payroll_calendar.utils.enums.SlaUnitType;

@Entity
@Table(name = "sla")
@Data
public class Sla {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sla_id", nullable = false, updatable = false)
    private UUID slaId;

    @Column(name = "sla_name", nullable = false)
    private String slaName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type", nullable = false)
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "catalog_id", nullable = false)
    private ServiceCatalog catalog;

    @ManyToOne
    @JoinColumn(name = "priority_id", nullable = false)
    private Priority priority;

    /*
    @ManyToOne
    @JoinColumn(name = "workflow_id", nullable = false)
    private Workflow workflow; */

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "sla_unit_type", nullable = false)
    private SlaUnitType slaUnitType;

    @Column(name = "sla_unit_value", nullable = false)
    private Integer slaUnitValue;
}