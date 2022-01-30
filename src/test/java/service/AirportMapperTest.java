package service;

import dto.AddressDto;
import dto.AirportDto;
import model.Address;
import model.Airport;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AirportMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final String TESTSTRING = "test";
    private static final int TESTINT = 1;
    private static final Address A = new Address();
    private static final AddressDto AD = new AddressDto();
    private static final AddressMapper ADDRESS_MAPPER = new AddressMapper();

    @Test
    void fromDto_returns_modelAirport() {
        // GIVEN
        AirportMapper airportMapper = new AirportMapper();
        AirportDto airportDto = new AirportDto()
                .id(ID)
                .name(TESTSTRING)
                .city(TESTSTRING)
                .code(TESTSTRING)
                .airstrips(TESTINT)
                .gates(TESTINT)
                .address(AD);

        // THEN
        Airport result = airportMapper.fromDto(airportDto);

        // THEN
        assertEquals(airportDto.id(),result.id());
        assertEquals(airportDto.name(),result.name());
        assertEquals(airportDto.city(),result.city());
        assertEquals(airportDto.code(),result.code());
        assertEquals(airportDto.airstrips(),result.airstrips());
        assertEquals(airportDto.gates(),result.gates());
        assertEquals(ADDRESS_MAPPER.fromDto(airportDto.address()), result.address());
    }
    @Test
    void fromDto_returns_nullModelAirport() {
        // GIVEN
        AirportMapper airportMapper = new AirportMapper();

        // THEN
        Airport result = airportMapper.fromDto(null);

        // THEN
        assertNull(result.id());
        assertNull(result.name());
        assertNull(result.city());
        assertNull(result.code());
        assertEquals(0,result.airstrips());
        assertEquals(0,result.gates());
        assertNull(result.address());
    }

    @Test
    void toDto_returns_AirportDto() {
        // GIVEN
        AirportMapper airportMapper = new AirportMapper();
        Airport airportDto = new Airport()
                .id(ID)
                .name(TESTSTRING)
                .city(TESTSTRING)
                .code(TESTSTRING)
                .airstrips(TESTINT)
                .gates(TESTINT)
                .address(A);

        // THEN
        AirportDto result = airportMapper.toDto(airportDto);

        // THEN
        assertEquals(airportDto.id(),result.id());
        assertEquals(airportDto.name(),result.name());
        assertEquals(airportDto.city(),result.city());
        assertEquals(airportDto.code(),result.code());
        assertEquals(airportDto.airstrips(),result.airstrips());
        assertEquals(airportDto.gates(),result.gates());
        assertEquals(ADDRESS_MAPPER.toDto(airportDto.address()), result.address());
    }

    @Test
    void toDto_returns_nullAirportDto() {
        // GIVEN
        AirportMapper airportMapper = new AirportMapper();

        // THEN
        AirportDto result = airportMapper.toDto(null);

        // THEN
        assertNull(result.id());
        assertNull(result.name());
        assertNull(result.city());
        assertNull(result.code());
        assertEquals(0,result.airstrips());
        assertEquals(0,result.gates());
        assertNull(result.address());
    }
}