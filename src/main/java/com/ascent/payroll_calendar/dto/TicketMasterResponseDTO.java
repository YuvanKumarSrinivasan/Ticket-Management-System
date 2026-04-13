package com.ascent.payroll_calendar.dto;

import lombok.Data;

import java.util.UUID;
import java.util.Date;

@Data
public class TicketMasterResponseDTO {

    private UUID ticketId;
    private String subject;
    private String description;
    private String ticketType;

    private String sourceName;

    private String catalogName;
    private String categoryName;
    private String subCategoryName;
    private String priorityName;
    private String statusName;

    private UUID customerId;
    private UUID processorId;

    private String deepLink;

    private Date createdDt;
    private Date duedt;
    private Date closedDt;
    private UUID closedBy;
}