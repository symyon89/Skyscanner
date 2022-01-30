package service;

import dto.AirportDto;
import dto.TicketDto;
import model.Airport;
import model.Ticket;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.DefaultRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class TicketServiceTest {
    private final DefaultRepository<Ticket> ticketRepository = Mockito.mock(DefaultRepository.class);
    private final TicketService ticketService = new TicketService(ticketRepository);

    @Test
    void save_calls_repositorySave() {
        // GIVEN
        TicketDto ticketDto = new TicketDto();

        // WHEN
        ticketService.save(ticketDto);

        // THEN
        Mockito.verify(ticketRepository).save(any());
    }

    @Test
    void findAll_calls_repositoryFindAll() {
        // GIVEN

        // WHEN
        ticketService.findAll();

        //THEN
        Mockito.verify(ticketRepository).findAll("from Ticket");
    }

    @Test
    void findByID_calls_repositoryFindByID() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        ticketService.findById(id);

        // THEN
        Mockito.verify(ticketRepository).findById(id,Ticket.class);
    }

    @Test
    void remove_calls_removeRepository() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        ticketService.remove(id);

        // THEN
        Mockito.verify(ticketRepository).removeById(id, Ticket.class);
    }

    @Test
    void findByCode_calls_repositoryFindBy() {
        // GIVEN
        String code = "code";

        // WHEN
        ticketService.findByCode(code);

        // THEN
        Mockito.verify(ticketRepository).findBy("from Ticket","code",code);
    }
}