package service;

import dto.AddressDto;
import dto.PassengerDto;
import model.Address;
import model.Passenger;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PassengerMapperTest {
    private final UUID ID = UUID.randomUUID();
    private final String TESTSTRING = "test";
    private final int TESTINT = 10;
    private final boolean TESTTRUE = true;
    private final AddressMapper addressMapper = new AddressMapper();

    @Test
    void fromDto_returns_modelPassenger() {
        // GIVEN
        PassengerMapper passengerMapper = new PassengerMapper();
        PassengerDto passengerDto = new PassengerDto()
                .id(ID)
                .firstName(TESTSTRING)
                .lastName(TESTSTRING)
                .number(TESTSTRING)
                .series(TESTSTRING)
                .isInsured(TESTTRUE)
                .phoneNumber(TESTSTRING)
                .email(TESTSTRING)
                .address(new AddressDto());

        // WHEN
        Passenger result = passengerMapper.fromDto(passengerDto);

        // THEN
        assertEquals(passengerDto.id(), result.id());
        assertEquals(passengerDto.firstName(), result.firstName());
        assertEquals(passengerDto.lastName(), result.lastName());
        assertEquals(passengerDto.number(), result.number());
        assertEquals(passengerDto.series(), result.series());
        assertEquals(passengerDto.isInsured(), result.isInsured());
        assertEquals(passengerDto.phoneNumber(), result.phoneNumber());
        assertEquals(passengerDto.email(), result.email());
        assertEquals(addressMapper.fromDto(passengerDto.address()), result.address());
    }

    @Test
    void fromDto_returns_nullModelPassenger() {
        // GIVEN
        PassengerMapper passengerMapper = new PassengerMapper();

        // WHEN
        Passenger result = passengerMapper.fromDto(null);

        // THEN
        assertNull(result.id());
        assertNull(result.firstName());
        assertNull(result.lastName());
        assertNull(result.number());
        assertNull(result.series());
        assertEquals(false,result.isInsured());
        assertNull(result.phoneNumber());
        assertNull(result.email());
        assertNull(result.address());
    }

    @Test
    void toDto_returns_PassengerDto() {
        // GIVEN
        PassengerMapper passengerMapper = new PassengerMapper();
        Passenger passenger = new Passenger()
                .id(ID)
                .firstName(TESTSTRING)
                .lastName(TESTSTRING)
                .number(TESTSTRING)
                .series(TESTSTRING)
                .isInsured(TESTTRUE)
                .phoneNumber(TESTSTRING)
                .email(TESTSTRING)
                .address(new Address());

        // WHEN
        PassengerDto result = passengerMapper.toDto(passenger);

        // THEN
        assertEquals(passenger.id(), result.id());
        assertEquals(passenger.firstName(), result.firstName());
        assertEquals(passenger.lastName(), result.lastName());
        assertEquals(passenger.number(), result.number());
        assertEquals(passenger.series(), result.series());
        assertEquals(passenger.isInsured(), result.isInsured());
        assertEquals(passenger.phoneNumber(), result.phoneNumber());
        assertEquals(passenger.email(), result.email());
        assertEquals(addressMapper.toDto(passenger.address()), result.address());
    }

    @Test
    void toDto_returns_nullPassengerDto() {
        // GIVEN
        PassengerMapper passengerMapper = new PassengerMapper();

        // WHEN
        PassengerDto result = passengerMapper.toDto(null);

        // THEN
        assertNull(result.id());
        assertNull(result.firstName());
        assertNull(result.lastName());
        assertNull(result.number());
        assertNull(result.series());
        assertEquals(false,result.isInsured());
        assertNull(result.phoneNumber());
        assertNull(result.email());
        assertNull(result.address());
    }
}