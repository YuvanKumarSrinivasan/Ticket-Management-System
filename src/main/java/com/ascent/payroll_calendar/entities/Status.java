package com.ascent.payroll_calendar.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

import com.ascent.payroll_calendar.utils.enums.StatusValue;

@Entity
@Table(name = "status")
@Data
public class Status {

    @Id
    @GeneratedValue
    @Column(name = "status_id", nullable = false, updatable = false)
    private UUID statusId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_value", nullable = false)
    private StatusValue statusValue;

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

    @JsonCreator
    public Status(
            @JsonProperty("status_value") StatusValue statusValue,
            @JsonProperty("created_by") String createdBy,
            @JsonProperty("updated_by") String updatedBy
    ) {
        this.statusValue = statusValue;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
    public Status() {}
}
