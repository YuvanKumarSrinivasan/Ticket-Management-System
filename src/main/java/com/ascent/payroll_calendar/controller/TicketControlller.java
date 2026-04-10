package com.ascent.payroll_calendar.controller;
import com.ascent.payroll_calendar.dto.TicketMasterDTO;
import com.ascent.payroll_calendar.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketControlller {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/")
    public ResponseEntity<String> createTicket(@RequestBody TicketMasterDTO ticketMasterDTO) {
        ticketService.createTicket(ticketMasterDTO);
        return ResponseEntity.ok("Ticket created successfully");
    }


}
