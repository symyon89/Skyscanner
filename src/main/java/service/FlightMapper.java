package service;

import dto.FlightDto;
import model.Flight;

public class FlightMapper {
    private final AirportMapper airportMapper = new AirportMapper();
    private final AircraftMapper aircraftMapper = new AircraftMapper();

    public Flight fromDto(FlightDto flightDto) {
        Flight flight = new Flight()
                .id(flightDto.id())
                .code(flightDto.code())
                .distance(flightDto.distance())
                .departureDate(flightDto.departureDate())
                .arrivalDate(flightDto.arrivalDate());
        if(flightDto.departure() != null) {
            flight.departure(airportMapper.fromDto(flightDto.departure()));
        }
        if(flightDto.arrival() != null) {
            flight.arrival(airportMapper.fromDto(flightDto.arrival()));
        }
        if(flightDto.aircraft() != null) {
            flight.aircraft(aircraftMapper.fromDto(flightDto.aircraft()));
        }
        return flight;
    }

    public FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto()
                .id(flight.id())
                .code(flight.code())
                .distance(flight.distance())
                .departureDate(flight.departureDate())
                .arrivalDate(flight.arrivalDate());
        if (flight.departure() != null) {
            flightDto.departure(airportMapper.toDto(flight.departure()));
        }
        if (flight.arrival() != null) {
            flightDto.arrival(airportMapper.toDto(flight.arrival()));
        }
        if (flight.aircraft() != null) {
            flightDto.aircraft(aircraftMapper.toDto(flight.aircraft()));
        }
        return flightDto;
    }

}
