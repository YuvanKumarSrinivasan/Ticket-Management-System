package com.ascent.payroll_calendar.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TicketRequestDTO {

    private UUID sourceId;
    private String subject;
    private String description;

    private UUID statusId;
    private UUID priorityId;
    private UUID customerId;
    private UUID processorId;

    private UUID slaId;

    //private Long createdBy;
    //private LocalDateTime createdDate;

    //private LocalDateTime closedDate;

}