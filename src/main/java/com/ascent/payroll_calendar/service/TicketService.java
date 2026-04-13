package com.ascent.payroll_calendar.service;

import com.ascent.payroll_calendar.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface TicketService {

    void createTicket(TicketMasterRequestDTO dto);

    Page<TicketMasterResponseDTO> getAllTickets(Pageable pageable);

    TicketMasterResponseDTO getTicketById(UUID ticketId);

    void updateTicket(UUID ticketId, TicketMasterRequestDTO dto);

    void updateTicketStatus(UUID ticketMasterId, TicketStatusUpdateDTO dto);

    void createChildTicket(ChildTicketMasterRequestDTO dto);

    List<ChildTicketMasterResponseDTO> getChildTickets(UUID ticketmasterid);

    ChildTicketMasterResponseDTO getChildTicketById(UUID ticketMasterId, UUID childticketMasterId);

    void updateChildTicket(UUID ticketMasterId, UUID childticketMasterId, ChildTicketMasterRequestDTO request);

    void updateChildTicketStatus(UUID ticketMasterId, UUID childticketMasterId, TicketStatusUpdateDTO request);

}