package com.example.ManagementEOS.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository systemRepository) {
        this.ticketRepository = systemRepository;
    }

    public List<Ticket> getTickets(){
        return ticketRepository.findAll();
    }

    public void addNewTicket(Ticket tick) {
        ticketRepository.save(tick);
    }

    public void deleteTicket(Integer ticketId) {
        boolean exists = ticketRepository.existsById(ticketId);
        if (!exists){
            throw new IllegalStateException(
                    "ticket with id " + ticketId + " does not exist :(");

        }
        ticketRepository.deleteById(ticketId);
    }

    @Transactional
    public void updateTicket(Integer ticketId, String description, Developer devAssigned, boolean finished) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalStateException(
                        "ticket with id "+ ticketId+ " does not exist :("));

        if (description != null && description.length()>0 &&
                !Objects.equals(ticket.getDescription(), description)){
            ticket.setDescription(description);
        }

        if (devAssigned != null){
            ticket.setDevAssigned(devAssigned);
        }

    }
}
