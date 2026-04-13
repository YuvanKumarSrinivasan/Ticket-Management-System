package com.ascent.payroll_calendar.controller;
import com.ascent.payroll_calendar.dto.TicketMasterRequestDTO;
import com.ascent.payroll_calendar.dto.TicketMasterResponseDTO;
import com.ascent.payroll_calendar.dto.TicketStatusUpdateDTO;
import com.ascent.payroll_calendar.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@RestController
@RequestMapping("/ticket")
public class TicketControlller {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Void> createTicket(@RequestBody TicketMasterRequestDTO ticketMasterDTO) {
        ticketService.createTicket(ticketMasterDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<TicketMasterResponseDTO>> getAllTickets(Pageable pageable) {
        Page<TicketMasterResponseDTO> tickets = ticketService.getAllTickets(pageable);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketMasterResponseDTO> getTicketById(@PathVariable("id") UUID ticketId) {
        return ResponseEntity.ok(ticketService.getTicketById(ticketId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTicket(@PathVariable UUID id, @RequestBody TicketMasterRequestDTO dto) {
        ticketService.updateTicket(id, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateTicketStatus(@PathVariable("id") UUID ticketMasterId, @RequestBody TicketStatusUpdateDTO dto) {

        ticketService.updateTicketStatus(ticketMasterId, dto);

        return ResponseEntity.ok().build();
    }


}
