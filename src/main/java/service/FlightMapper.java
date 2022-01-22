package service;

import dto.FlightDto;
import model.Flight;

public class FlightMapper {
    private AirportMapper airportMapper = new AirportMapper();
    private AircraftMapper aircraftMapper = new AircraftMapper();

    public Flight fromDto(FlightDto flightDto) {
        return new Flight()
                .id(flightDto.id())
                .departure(airportMapper.fromDto(flightDto.departure()))
                .arrival(airportMapper.fromDto(flightDto.departure()))
                .aircraft(aircraftMapper.fromDto(flightDto.aircraft()))
                .code(flightDto.code())
                .distance(flightDto.distance())
                .departureDate(flightDto.departureDate())
                .arrivalDate(flightDto.arrivalDate());
    }

    public FlightDto toDto(Flight flight) {
        return new FlightDto()
                .id(flight.id())
                .departure(airportMapper.toDto(flight.departure()))
                .arrival(airportMapper.toDto(flight.departure()))
                .aircraft(aircraftMapper.toDto(flight.aircraft()))
                .code(flight.code())
                .distance(flight.distance())
                .departureDate(flight.departureDate())
                .arrivalDate(flight.arrivalDate());
    }
}
