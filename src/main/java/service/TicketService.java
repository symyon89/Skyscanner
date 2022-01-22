package service;

import dto.TicketDto;
import lombok.Data;
import model.Ticket;
import repository.DefaultRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public void save(TicketDto ticketDto) {
        ticketRepository.save(ticketMapper.fromDto(ticketDto));
    }

    public List<TicketDto> findAll() {
        return ticketRepository.findAll("from Ticket")
                .stream()
                .map(ticket -> ticketMapper.toDto(ticket))
                .collect(Collectors.toList());
    }

    public TicketDto findById(UUID id) {
        return ticketMapper.toDto(ticketRepository.findById(id,Ticket.class));
    }

    public void remove(UUID id) {
        ticketRepository.removeById(id,Ticket.class);
    }

    public List<TicketDto> findByCode(String code) {
        return ticketRepository.findBy("from Ticket","code", code)
                .stream()
                .map(ticket -> ticketMapper.toDto(ticket))
                .collect(Collectors.toList());
    }

}
