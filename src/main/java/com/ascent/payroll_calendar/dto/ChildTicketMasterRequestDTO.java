package com.ascent.payroll_calendar.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ChildTicketMasterRequestDTO extends TicketRequestDTO {

    private UUID childTicketId;
    private UUID parentTicketId;

    // Getters and Setters
}