package com.ascent.payroll_calendar.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class ChildTicketMasterResponseDTO {
    private UUID childTicketId;
    private UUID ParentTicketId;
    private String subject;
    private String description;

    private String sourceName;

    private String priorityName;
    private String statusName;

    private UUID customerId;
    private UUID processorId;


    private Date createdDt;
    private Date duedt;
    private Date closedDt;

}
