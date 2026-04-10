package com.ascent.payroll_calendar.dto;

import lombok.Data;

@Data
public class ChildTicketDTO extends TicketBaseDTO {

    private Long childTicketId;
    private Long parentTicketId;

    // Getters and Setters
}