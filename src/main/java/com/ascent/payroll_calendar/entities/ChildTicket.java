package com.ascent.payroll_calendar.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "child_ticket")
@Data
public class ChildTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "child_ticket_id", nullable = false, updatable = false)
    private UUID childTicketId;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private TicketSource source;

    @ManyToOne
    @JoinColumn(name = "parent_ticket_id", nullable = false)
    private TicketMaster parentTicket;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "processor_id")
    private UUID processorId;

    @Column(name = "created_by")
    private UUID createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_dt", nullable = false)
    private Date createdDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "closed_dt")
    private Date closedDt;

    @ManyToOne
    @JoinColumn(name = "sla_id")
    private Sla sla;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_dt")
    private Date dueDt;
}