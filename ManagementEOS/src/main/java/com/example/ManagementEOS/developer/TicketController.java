package com.example.ManagementEOS.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "tick/")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getTickets(){
        return ticketService.getTickets();
    }

    @PostMapping
    public void registerNewTicket(@RequestBody Ticket tick) {
        ticketService.addNewTicket(tick);
    }

    @DeleteMapping(path = "{ticketId}")
    public void deleteTicket(
            @PathVariable("ticketId") Integer ticketId){
        ticketService.deleteTicket(ticketId);
    }

    @PutMapping(path = "{ticketId}")
    public void updateTicket(
            @PathVariable("ticketId") Integer ticketId,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Developer devAssigned,
            @RequestParam(required = false) boolean finished
    ) {

        ticketService.updateTicket(ticketId,description,devAssigned,finished);
    }

}
