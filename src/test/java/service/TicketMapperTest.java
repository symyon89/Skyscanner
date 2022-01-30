package service;

import dto.FlightDto;
import dto.PassengerDto;
import dto.TicketDto;
import model.Flight;
import model.Passenger;
import model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TicketMapperTest {
    private final PassengerMapper passengerMapper = new PassengerMapper();
    private final FlightMapper flightMapper = new FlightMapper();
    private final UUID ID = UUID.randomUUID();
    private final String TESTSTRING = "test";

    @Test
    void fromDto_returns_modelTicket() {
        // GIVEN
        TicketMapper ticketMapper = new TicketMapper();
        TicketDto ticketDto = new TicketDto()
                .id(ID)
                .seat(TESTSTRING)
                .code(TESTSTRING)
                .passenger(new PassengerDto())
                .flight(new FlightDto());
        // WHEN
        Ticket result = ticketMapper.fromDto(ticketDto);

        // THEN
        assertEquals(ticketDto.id(), result.id());
        assertEquals(ticketDto.seat(), result.seat());
        assertEquals(ticketDto.code(), result.code());
        assertEquals(passengerMapper.fromDto(ticketDto.passenger()), result.passenger());
        assertEquals(flightMapper.fromDto(ticketDto.flight()), result.flight());
    }

    @Test
    void fromDto_returns_nullModelTicket() {
        // GIVEN
        TicketMapper ticketMapper = new TicketMapper();

        // WHEN
        Ticket result = ticketMapper.fromDto(null);

        // THEN
        assertNull(result.id());
        assertNull(result.seat());
        assertNull(result.code());
        assertNull(result.passenger());
        assertNull(result.flight());
    }

    @Test
    void toDto_returns_modelTicket() {
        // GIVEN
        TicketMapper ticketMapper = new TicketMapper();
        Ticket ticket = new Ticket()
                .id(ID)
                .seat(TESTSTRING)
                .code(TESTSTRING)
                .passenger(new Passenger())
                .flight(new Flight());
        // WHEN
        TicketDto result = ticketMapper.toDto(ticket);

        // THEN
        assertEquals(ticket.id(), result.id());
        assertEquals(ticket.seat(), result.seat());
        assertEquals(ticket.code(), result.code());
        assertEquals(passengerMapper.toDto(ticket.passenger()), result.passenger());
        assertEquals(flightMapper.toDto(ticket.flight()), result.flight());
    }
    @Test
    void toDto_returns_nullTicketDto() {
        // GIVEN
        TicketMapper ticketMapper = new TicketMapper();

        // WHEN
        TicketDto result = ticketMapper.toDto(null);

        // THEN
        assertNull(result.id());
        assertNull(result.seat());
        assertNull(result.code());
        assertNull(result.passenger());
        assertNull(result.flight());
    }
}