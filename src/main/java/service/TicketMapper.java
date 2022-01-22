package service;

import dto.TicketDto;
import model.Ticket;

public class TicketMapper {
    private final PassengerMapper passengerMapper = new PassengerMapper();
    private final FlightMapper flightMapper = new FlightMapper();

    public Ticket fromDto(TicketDto ticketDto) {
        Ticket ticket = new Ticket()
                .id(ticketDto.id())
                .seat(ticketDto.seat())
                .code(ticketDto.code());
        if(ticketDto.passenger() != null) {
            ticket.passenger(passengerMapper.fromDto(ticketDto.passenger()));
        }
        if(ticketDto.flight() != null) {
            ticket.flight(flightMapper.fromDto(ticketDto.flight()));
        }
        return ticket;
    }

    public TicketDto toDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto()
                .id(ticket.id())
                .seat(ticket.seat())
                .code(ticket.code());
        if (ticket.passenger() != null) {
            ticketDto.passenger(passengerMapper.toDto(ticket.passenger()));
        }
        if (ticket.flight() != null) {
            ticketDto.flight(flightMapper.toDto(ticket.flight()));
        }
        return ticketDto;
    }
}
