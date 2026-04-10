package com.ascent.payroll_calendar.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "attachment")
@Data
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "attachment_id", nullable = false, updatable = false)
    private UUID attachmentId;


    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketMaster ticket;

    /*✅ Transaction Relationship (future audit/activity table)
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private TicketTransaction transaction;*/

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "uploaded_by")
    private UUID uploadedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "uploaded_dt", nullable = false)
    private Date uploadedDt;

    @Column(name = "delete_flag", length = 1)
    private String deleteFlag = "N";

    @Column(name = "delete_by")
    private UUID deleteBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delete_dt")
    private Date deleteDt;
}