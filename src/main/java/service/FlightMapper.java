package service;

import dto.FlightDto;
import model.Flight;

public class FlightMapper {
    private final AirportMapper airportMapper = new AirportMapper();
    private final AircraftMapper aircraftMapper = new AircraftMapper();

    public Flight fromDto(FlightDto flightDto) {
        return flightDto == null ? new Flight() : new Flight()
                .id(flightDto.id())
                .code(flightDto.code())
                .distance(flightDto.distance())
                .departureDate(flightDto.departureDate())
                .arrivalDate(flightDto.arrivalDate())
                .departure(airportMapper.fromDto(flightDto.departure()))
                .arrival(airportMapper.fromDto(flightDto.arrival()))
                .aircraft(aircraftMapper.fromDto(flightDto.aircraft()));
    }

    public FlightDto toDto(Flight flight) {
        return flight == null ? new FlightDto() : new FlightDto()
                .id(flight.id())
                .code(flight.code())
                .distance(flight.distance())
                .departureDate(flight.departureDate())
                .arrivalDate(flight.arrivalDate())
                .departure(airportMapper.toDto(flight.departure()))
                .arrival(airportMapper.toDto(flight.arrival()))
                .aircraft(aircraftMapper.toDto(flight.aircraft()));

    }

}
