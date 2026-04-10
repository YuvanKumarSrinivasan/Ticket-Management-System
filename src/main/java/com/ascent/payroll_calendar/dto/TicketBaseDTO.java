package com.ascent.payroll_calendar.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TicketBaseDTO {

    private Long sourceId;
    private String subject;
    private String description;

    private Long statusId;
    private Long priorityId;
    private Long customerId;
    private Long processorId;

    private Long slaId;

    //private Long createdBy;
    //private LocalDateTime createdDate;

    //private LocalDateTime closedDate;

}