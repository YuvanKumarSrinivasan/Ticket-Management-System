package com.ascent.payroll_calendar.repository;

import com.ascent.payroll_calendar.entities.ChildTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChildTicketRepository extends JpaRepository<ChildTicket, UUID> {

    @Query("SELECT c FROM ChildTicket c WHERE c.parentTicket.ticketId = :ticketId")
    List<ChildTicket> findByParentTicket_TicketId(@Param("ticketId") UUID ticketId);

    @Query("SELECT c FROM ChildTicket c " +
            "WHERE c.childTicketId = :childTicketId " +
            "AND c.parentTicket.ticketId = :ticketId")
    Optional<ChildTicket> findByChildTicketIdAndParentTicket_TicketId(
            @Param("childTicketId") UUID childTicketId,
            @Param("ticketId") UUID ticketId
    );


}