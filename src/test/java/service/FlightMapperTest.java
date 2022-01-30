package service;

import dto.AircraftDto;
import dto.AirportDto;
import dto.FlightDto;
import model.Aircraft;
import model.Airport;
import model.Flight;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FlightMapperTest {
    private final AirportMapper airportMapper = new AirportMapper();
    private final AircraftMapper aircraftMapper = new AircraftMapper();
    private final UUID ID = UUID.randomUUID();
    private final String TESTSTRING = "test";
    private final int TESTINT = 10;
    private final LocalTime TESTDATE = LocalTime.now();

    @Test
    void fromDto_returns_modelFlight() {
        // GIVEN
        FlightMapper flightMapper = new FlightMapper();
        FlightDto flightDto = new FlightDto()
                .id(ID)
                .code(TESTSTRING)
                .distance(TESTINT)
                .departureDate(TESTDATE)
                .arrivalDate(TESTDATE)
                .departure(new AirportDto())
                .arrival(new AirportDto())
                .aircraft(new AircraftDto());

        // WHEN
        Flight result = flightMapper.fromDto(flightDto);

        // THEN
        assertEquals(flightDto.id(), result.id());
        assertEquals(flightDto.code(), result.code());
        assertEquals(flightDto.distance(), result.distance());
        assertEquals(flightDto.departureDate(), result.departureDate());
        assertEquals(flightDto.arrivalDate(), result.arrivalDate());
        assertEquals(airportMapper.fromDto(flightDto.departure()), result.departure());
        assertEquals(airportMapper.fromDto(flightDto.arrival()), result.arrival());
        assertEquals(aircraftMapper.fromDto(flightDto.aircraft()), result.aircraft());
    }

    @Test
    void fromDto_returns_nullModelFlight() {
        // GIVEN
        FlightMapper flightMapper = new FlightMapper();

        // WHEN
        Flight result = flightMapper.fromDto(null);

        // THEN
        assertNull(result.id());
        assertNull(result.code());
        assertNull(result.distance());
        assertNull(result.departureDate());
        assertNull(result.arrivalDate());
        assertNull(result.departure());
        assertNull(result.arrival());
        assertNull(result.aircraft());
    }

    @Test
    void toDto_returns_FlightDto() {
        // GIVEN
        FlightMapper flightMapper = new FlightMapper();
        Flight flight = new Flight()
                .id(ID)
                .code(TESTSTRING)
                .distance(TESTINT)
                .departureDate(TESTDATE)
                .arrivalDate(TESTDATE)
                .departure(new Airport())
                .arrival(new Airport())
                .aircraft(new Aircraft());

        // WHEN
        FlightDto result = flightMapper.toDto(flight);

        // THEN
        assertEquals(flight.id(), result.id());
        assertEquals(flight.code(), result.code());
        assertEquals(flight.distance(), result.distance());
        assertEquals(flight.departureDate(), result.departureDate());
        assertEquals(flight.arrivalDate(), result.arrivalDate());
        assertEquals(airportMapper.toDto(flight.departure()), result.departure());
        assertEquals(airportMapper.toDto(flight.arrival()), result.arrival());
        assertEquals(aircraftMapper.toDto(flight.aircraft()), result.aircraft());
    }
    @Test
    void toDto_returns_nullFlightDto() {
        // GIVEN
        FlightMapper flightMapper = new FlightMapper();

        // WHEN
        FlightDto result = flightMapper.toDto(null);

        // THEN
        assertNull(result.id());
        assertNull(result.code());
        assertNull(result.distance());
        assertNull(result.departureDate());
        assertNull(result.arrivalDate());
        assertNull(result.departure());
        assertNull(result.arrival());
        assertNull(result.aircraft());
    }
}