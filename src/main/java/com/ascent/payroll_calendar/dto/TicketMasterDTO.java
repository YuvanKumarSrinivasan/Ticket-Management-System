package com.ascent.payroll_calendar.dto;

import lombok.Data;

@Data
public class TicketMasterDTO extends TicketBaseDTO {

    //private Long ticketId;
    private String ticketType;

    private Long catalogId;
    private Long categoryId;
    private Long subCategoryId;

    //private Long closedBy;

    private String deepLink;
}