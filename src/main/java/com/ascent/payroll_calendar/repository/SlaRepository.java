package com.ascent.payroll_calendar.repository;

import com.ascent.payroll_calendar.entities.Sla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SlaRepository extends JpaRepository<Sla, UUID> {
}