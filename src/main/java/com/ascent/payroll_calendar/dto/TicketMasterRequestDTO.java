package com.ascent.payroll_calendar.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TicketMasterRequestDTO extends TicketRequestDTO {

    //private Long ticketId;
    private String ticketType;

    private UUID catalogId;
    private UUID categoryId;
    private UUID subCategoryId;

    //private Long closedBy;

    private String deepLink;
}