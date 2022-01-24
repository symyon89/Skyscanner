package service;

import dto.TicketDto;
import model.Ticket;

public class TicketMapper {
    private final PassengerMapper passengerMapper = new PassengerMapper();
    private final FlightMapper flightMapper = new FlightMapper();

    public Ticket fromDto(TicketDto ticketDto) {
        return ticketDto == null ? new Ticket() : new Ticket()
                .id(ticketDto.id())
                .seat(ticketDto.seat())
                .code(ticketDto.code())
                .passenger(passengerMapper.fromDto(ticketDto.passenger()))
                .flight(flightMapper.fromDto(ticketDto.flight()));
    }

    public TicketDto toDto(Ticket ticket) {
        return ticket == null ? new TicketDto() : new TicketDto()
                .id(ticket.id())
                .seat(ticket.seat())
                .code(ticket.code())
                .passenger(passengerMapper.toDto(ticket.passenger()))
                .flight(flightMapper.toDto(ticket.flight()));

    }
}
