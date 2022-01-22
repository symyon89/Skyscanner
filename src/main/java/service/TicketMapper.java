package service;

import dto.TicketDto;
import model.Ticket;

public class TicketMapper {
    private PassengerMapper passengerMapper = new PassengerMapper();
    private FlightMapper flightMapper = new FlightMapper();

    public Ticket fromDto(TicketDto ticketDto) {
        return new Ticket()
                .id(ticketDto.id())
                .passenger(passengerMapper.fromDto(ticketDto.passenger()))
                .seat(ticketDto.seat())
                .code(ticketDto.code())
                .flight(flightMapper.fromDto(ticketDto.flight()));
    }

    public TicketDto fromDto(Ticket ticket) {
        return new TicketDto()
                .id(ticket.id())
                .passenger(passengerMapper.toDto(ticket.passenger()))
                .seat(ticket.seat())
                .code(ticket.code())
                .flight(flightMapper.toDto(ticket.flight()));
    }
}
