package com.ascent.payroll_calendar.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

import com.ascent.payroll_calendar.utils.enums.PriorityValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "priority")
@Data
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "priority_id", nullable = false, updatable = false)
    private UUID priorityId;

    @Column(name = "priority_name", nullable = false)
    private String priorityName;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority_value", nullable = false)
    private PriorityValue priorityValue;

    @Column(name = "color_code")
    private String colorCode;

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