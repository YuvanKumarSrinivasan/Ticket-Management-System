package com.ascent.payroll_calendar.controller;
import com.ascent.payroll_calendar.dto.*;
import com.ascent.payroll_calendar.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
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

    /*@GetMapping
    public ResponseEntity<Page<TicketMasterResponseDTO>> getAllTickets(Pageable pageable) {
        Page<TicketMasterResponseDTO> tickets = ticketService.getAllTickets(pageable);
        return ResponseEntity.ok(tickets);
    }*/
    @GetMapping
    public ResponseEntity<Page<TicketMasterResponseDTO>> getAllTickets(@RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

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
    @PostMapping("/child")
    public ResponseEntity<Void> createChildTicket(@RequestBody ChildTicketMasterRequestDTO childTicketMasterDTO) {
        ticketService.createChildTicket(childTicketMasterDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{ticketmasterid}/child")
    public ResponseEntity<List<ChildTicketMasterResponseDTO>> getChildTickets(@PathVariable UUID ticketmasterid) {
        List<ChildTicketMasterResponseDTO> response = ticketService.getChildTickets(ticketmasterid);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{ticketMasterId}/child/{childticketMasterId}")
    public ResponseEntity<ChildTicketMasterResponseDTO> getChildTicketById(
            @PathVariable UUID ticketMasterId,
            @PathVariable UUID childticketMasterId) {

        ChildTicketMasterResponseDTO response =
                ticketService.getChildTicketById(ticketMasterId, childticketMasterId);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{ticketMasterId}/child/{childticketMasterId}")
    public ResponseEntity<Void> updateChildTicket(
            @PathVariable UUID ticketMasterId,
            @PathVariable UUID childticketMasterId,
            @RequestBody ChildTicketMasterRequestDTO request) {

        ticketService.updateChildTicket(ticketMasterId, childticketMasterId, request);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{ticketMasterId}/child/{childticketMasterId}/status")
    public ResponseEntity<Void> updateChildTicketStatus(
            @PathVariable UUID ticketMasterId,
            @PathVariable UUID childticketMasterId,
            @RequestBody TicketStatusUpdateDTO request) {

        ticketService.updateChildTicketStatus(ticketMasterId, childticketMasterId, request);

        return ResponseEntity.ok().build();
    }








}
