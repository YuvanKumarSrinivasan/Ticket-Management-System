package com.ascent.payroll_calendar.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

import com.ascent.payroll_calendar.utils.enums.TicketType;

@Entity
@Table(name = "ticket_master")
@Data
public class TicketMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ticket_id", nullable = false, updatable = false)
    private UUID ticketId;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private TicketSource source;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "processor_id")
    private UUID processorId;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type", nullable = false)
    private TicketType ticketType;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private ServiceCatalog catalog;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @Column(name = "created_by")
    private UUID createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_dt", nullable = false)
    private Date createdDt;

    @ManyToOne
    @JoinColumn(name = "sla_id")
    private Sla sla;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_dt")
    private Date dueDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "closed_dt")
    private Date closedDt;

    @Column(name = "closed_by")
    private UUID closedBy;

    @Column(name = "deep_link")
    private String deepLink;
}