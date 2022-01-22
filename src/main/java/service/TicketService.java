package service;

import lombok.Data;
import model.Ticket;
import repository.DefaultRepository;

@Data
public class TicketService {
    private DefaultRepository<Ticket> ticketRepository;
    private TicketMapper ticketMapper = new TicketMapper();

    public TicketService() {
        this.ticketRepository = new DefaultRepository<>();
    }

    public TicketService(DefaultRepository<Ticket> ticketRepository) {
        this.ticketRepository = ticketRepository;
    }



}
