package com.ascent.payroll_calendar.serviceimpl;

import com.ascent.payroll_calendar.dto.TicketMasterRequestDTO;
import com.ascent.payroll_calendar.dto.TicketMasterResponseDTO;
import com.ascent.payroll_calendar.dto.TicketStatusUpdateDTO;
import com.ascent.payroll_calendar.entities.*;
import com.ascent.payroll_calendar.repository.*;
import com.ascent.payroll_calendar.service.TicketService;
import com.ascent.payroll_calendar.utils.enums.TicketType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ServiceCatalogRepository serviceCatalogRepository;

    @Autowired
    private PriorityRepository priorityRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private TicketSourceRepository ticketSourceRepository;

    @Autowired
    private SlaRepository slaRepository;

    @Autowired
    private StatusRepository statusRepository;


    @Override
    public void createTicket(TicketMasterRequestDTO dto) {

        TicketMaster ticket = new TicketMaster();
        ticket.setTicketType(TicketType.valueOf(dto.getTicketType()));
        ticket.setSubject(dto.getSubject());
        ticket.setDescription(dto.getDescription());
        if (dto.getCatalogId() != null) {
            ServiceCatalog catalog =serviceCatalogRepository.findById(dto.getCatalogId())
                    .orElseThrow(() -> new RuntimeException("Catalog not found"));

            ticket.setCatalog(catalog);
        }
        if(dto.getPriorityId() != null){
            Priority priority=priorityRepository.findById(dto.getPriorityId())
                    .orElseThrow(()-> new RuntimeException("Priority not found"));
            ticket.setPriority(priority);
        }

        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            ticket.setCategory(category);
        }

        if (dto.getSubCategoryId() != null) {
            SubCategory subCategory = subCategoryRepository.findById(dto.getSubCategoryId())
                    .orElseThrow(() -> new RuntimeException("SubCategory not found"));
            ticket.setSubCategory(subCategory);
        }

        if (dto.getSourceId() != null) {
            TicketSource source = ticketSourceRepository.findById(dto.getSourceId())
                    .orElseThrow(() -> new RuntimeException("Source not found"));
            ticket.setSource(source);
        }

        if (dto.getSlaId() != null) {
            Sla sla = slaRepository.findById(dto.getSlaId())
                    .orElseThrow(() -> new RuntimeException("SLA not found"));
            ticket.setSla(sla);
        }

        if (dto.getStatusId() != null){
            Status status=statusRepository.findById(dto.getStatusId())
                    .orElseThrow(()-> new RuntimeException("Status not found"));
            ticket.setStatus(status);
        }

        ticket.setDeepLink(dto.getDeepLink());
        ticket.setCustomerId(dto.getCustomerId());
        ticket.setProcessorId(dto.getProcessorId());
        ticket.setCreatedDt(new Date());
        ticketRepository.save(ticket);

    }

    @Override
    public Page<TicketMasterResponseDTO> getAllTickets(Pageable pageable) {
        Page<TicketMaster> ticketPage = ticketRepository.findAll(pageable);
        return ticketPage.map(this::convertToDTO);
    }

    private TicketMasterResponseDTO convertToDTO(TicketMaster ticket) {

        TicketMasterResponseDTO dto = new TicketMasterResponseDTO();

        dto.setTicketId(ticket.getTicketId());
        dto.setSubject(ticket.getSubject());
        dto.setDescription(ticket.getDescription());

        if (ticket.getTicketType() != null)
            dto.setTicketType(ticket.getTicketType().name());

        if (ticket.getSource() != null)
            dto.setSourceName(String.valueOf(ticket.getSource().getSourceName()));

        if (ticket.getCatalog() != null)
            dto.setCatalogName(ticket.getCatalog().getCatalogName());

        if (ticket.getCategory() != null)
            dto.setCategoryName(ticket.getCategory().getCategoryValue());

        if (ticket.getSubCategory() != null)
            dto.setSubCategoryName(ticket.getSubCategory().getSubCategoryName());

        if (ticket.getPriority() != null)
            dto.setPriorityName(String.valueOf(ticket.getPriority().getPriorityValue()));

        if (ticket.getStatus() != null)
            dto.setStatusName(String.valueOf(ticket.getStatus().getStatusValue()));

        dto.setCustomerId(ticket.getCustomerId());
        dto.setProcessorId(ticket.getProcessorId());

        dto.setDeepLink(ticket.getDeepLink());
        dto.setCreatedDt(ticket.getCreatedDt());
        dto.setClosedDt(ticket.getClosedDt());
        dto.setDuedt(ticket.getDueDt());
        dto.setClosedBy(ticket.getClosedBy());

        return dto;
    }

    @Override
    public TicketMasterResponseDTO getTicketById(UUID ticketId) {

        TicketMaster ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        return convertToDTO(ticket);
    }

    @Override
    public void updateTicket(UUID ticketId, TicketMasterRequestDTO dto) {

        TicketMaster ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (dto.getSubject() != null)
            ticket.setSubject(dto.getSubject());

        if (dto.getDescription() != null)
            ticket.setDescription(dto.getDescription());

        if (dto.getTicketType() != null) {
            try {
                ticket.setTicketType(TicketType.valueOf(dto.getTicketType()));
            } catch (Exception e) {
                throw new RuntimeException("Invalid Ticket Type");
            }
        }

        if (dto.getDeepLink() != null)
            ticket.setDeepLink(dto.getDeepLink());

        if (dto.getSourceId() != null) {
            TicketSource source = ticketSourceRepository.findById(dto.getSourceId())
                    .orElseThrow(() -> new RuntimeException("Source not found"));
            ticket.setSource(source);
        }

        if (dto.getCatalogId() != null) {
            ServiceCatalog catalog = serviceCatalogRepository.findById(dto.getCatalogId())
                    .orElseThrow(() -> new RuntimeException("Catalog not found"));
            ticket.setCatalog(catalog);
        }

        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            ticket.setCategory(category);
        }

        if (dto.getSubCategoryId() != null) {
            SubCategory subCategory = subCategoryRepository.findById(dto.getSubCategoryId())
                    .orElseThrow(() -> new RuntimeException("SubCategory not found"));
            ticket.setSubCategory(subCategory);
        }

        if (dto.getPriorityId() != null) {
            Priority priority = priorityRepository.findById(dto.getPriorityId())
                    .orElseThrow(() -> new RuntimeException("Priority not found"));
            ticket.setPriority(priority);
        }

        if (dto.getStatusId() != null) {
            Status status = statusRepository.findById(dto.getStatusId())
                    .orElseThrow(() -> new RuntimeException("Status not found"));
            ticket.setStatus(status);
        }

        if (dto.getSlaId() != null) {
            Sla sla = slaRepository.findById(dto.getSlaId())
                    .orElseThrow(() -> new RuntimeException("SLA not found"));
            ticket.setSla(sla);
        }

        if (dto.getCustomerId() != null)
            ticket.setCustomerId(dto.getCustomerId());

        if (dto.getProcessorId() != null)
            ticket.setProcessorId(dto.getProcessorId());
        ticketRepository.save(ticket);
    }

    @Override
    public void updateTicketStatus(UUID ticketMasterId, TicketStatusUpdateDTO dto) {

        TicketMaster ticket = ticketRepository.findById(ticketMasterId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (!ticketMasterId.equals(dto.getTicketId())) {
            throw new RuntimeException("Ticket ID are mismatch");
        }
        if (dto.getStatusId() != null) {
            Status status = statusRepository.findById(dto.getStatusId())
                    .orElseThrow(() -> new RuntimeException("Status not found"));
            ticket.setStatus(status);
        }
        ticketRepository.save(ticket);
    }
}
