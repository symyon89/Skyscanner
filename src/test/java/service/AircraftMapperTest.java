package service;

import dto.AircraftDto;
import dto.AirportDto;
import dto.CompanyDto;
import dto.CountryDto;
import model.Aircraft;
import model.Company;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AircraftMapperTest {
    private final UUID ID = UUID.randomUUID();
    private final String TESTSTRING = "test";
    private final int TESTINT = 10;

    @Test
    void fromDto_returns_modelAircraft() {
        // GIVEN
        AircraftMapper aircraftMapper = new AircraftMapper();
        AircraftDto aircraftDto = new AircraftDto()
                .id(ID)
                .name(TESTSTRING)
                .seats(TESTINT)
                .company(new CompanyDto());

        // WHEN
        Aircraft result = aircraftMapper.fromDto(aircraftDto);

        // THEN
        assertEquals(aircraftDto.id(), result.id());
        assertEquals(aircraftDto.name(), result.name());
        assertEquals(aircraftDto.seats(), result.seats());
        assertEquals(new Company(), result.company());

    }

    @Test
    void fromDto_returns_nullModelAircraft() {
        // GIVEN
        AircraftMapper aircraftMapper = new AircraftMapper();
        AircraftDto aircraftDto = null;

        // WHEN
        Aircraft result = aircraftMapper.fromDto(aircraftDto);

        // THEN
        assertEquals(null, result.id());
        assertEquals(null, result.name());
        assertEquals(0, result.seats());
        assertEquals(null, result.company());

    }

    @Test
    void toDto_returns_AircraftDto() {
        // GIVEN
        AircraftMapper aircraftMapper = new AircraftMapper();
        Aircraft aircraft = new Aircraft()
                .id(ID)
                .name(TESTSTRING)
                .seats(TESTINT)
                .company(new Company());

        // WHEN
        AircraftDto result = aircraftMapper.toDto(aircraft);

        // THEN
        assertEquals(aircraft.id(), result.id());
        assertEquals(aircraft.name(), result.name());
        assertEquals(aircraft.seats(), result.seats());
        assertEquals(new CompanyDto(), result.company());
    }

    @Test
    void toDto_returns_nullAircraftDto() {
        // GIVEN
        AircraftMapper aircraftMapper = new AircraftMapper();
        Aircraft aircraft = null;

        // WHEN
        AircraftDto result = aircraftMapper.toDto(aircraft);

        // THEN
        assertEquals(null, result.id());
        assertEquals(null, result.name());
        assertEquals(0, result.seats());
        assertEquals(null, result.company());
    }
}