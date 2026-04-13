package com.ascent.payroll_calendar.repository;

import com.ascent.payroll_calendar.entities.TicketSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketSourceRepository extends JpaRepository<TicketSource, UUID> {
}