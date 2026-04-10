package com.ascent.payroll_calendar.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "activity_type")
@Data
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "activity_type_id", nullable = false, updatable = false)
    private UUID activityTypeId;

    @Column(name = "activity_name", nullable = false)
    private String activityName;

    /* ✅ If you want Y/N instead of true/false
    @Column(name = "is_active", nullable = false, length = 1)
    private String isActive = "Y";   // Y or N */

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_dt", nullable = false, updatable = false)
    private Date createdDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_dt")
    private Date updatedDt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;
}