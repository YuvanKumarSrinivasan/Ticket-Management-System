package com.ascent.payroll_calendar.service;

import com.ascent.payroll_calendar.dto.TicketMasterRequestDTO;
import com.ascent.payroll_calendar.dto.TicketMasterResponseDTO;
import com.ascent.payroll_calendar.dto.TicketStatusUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TicketService {

    void createTicket(TicketMasterRequestDTO dto);

    Page<TicketMasterResponseDTO> getAllTickets(Pageable pageable);

    TicketMasterResponseDTO getTicketById(UUID ticketId);

    void updateTicket(UUID ticketId, TicketMasterRequestDTO dto);

    void updateTicketStatus(UUID ticketMasterId, TicketStatusUpdateDTO dto);


}