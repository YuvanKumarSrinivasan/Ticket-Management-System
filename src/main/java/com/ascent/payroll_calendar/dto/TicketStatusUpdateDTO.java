package com.ascent.payroll_calendar.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class TicketStatusUpdateDTO {
    private UUID ticketId;
    private UUID statusId;
}