package service;

import dto.AddressDto;
import dto.CountryDto;
import model.Address;
import model.Country;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AddressMapperTest {
    private final UUID ID = UUID.randomUUID();
    private final String TESTSTRING = "test";

    @Test
    void fromDto_returns_modelAddress() {
        // GIVEN
        AddressMapper addressMapper = new AddressMapper();
        AddressDto addressDto = new AddressDto()
                .id(ID)
                .appartement(TESTSTRING)
                .street(TESTSTRING)
                .number(TESTSTRING)
                .building(TESTSTRING)
                .county(TESTSTRING)
                .country(new CountryDto());

        // WHEN
        Address result = addressMapper.fromDto(addressDto);

        // THEN
        assertEquals(addressDto.id(), result.id());
        assertEquals(addressDto.appartement(), result.appartement());
        assertEquals(addressDto.number(), result.number());
        assertEquals(addressDto.building(), result.building());
        assertEquals(addressDto.street(), result.street());
        assertEquals(addressDto.county(), result.county());
        assertEquals(new Country(), result.country());
    }

    @Test
    void fromDto_returns_nullModelAddress() {
        // GIVEN
        AddressMapper addressMapper = new AddressMapper();

        // WHEN
        Address result = addressMapper.fromDto(null);

        // THEN
        assertNull( result.id());
        assertNull( result.appartement());
        assertNull( result.number());
        assertNull( result.building());
        assertNull( result.street());
        assertNull( result.county());
        assertNull( result.country());
    }

    @Test
    void toDto_returns_AddressDto() {
        // GIVEN
        AddressMapper addressMapper = new AddressMapper();
        Address address = new Address()
                .id(ID)
                .appartement(TESTSTRING)
                .street(TESTSTRING)
                .number(TESTSTRING)
                .building(TESTSTRING)
                .county(TESTSTRING)
                .country(new Country());

        // WHEN
        AddressDto result = addressMapper.toDto(address);

        // THEN
        assertEquals(address.id(), result.id());
        assertEquals(address.appartement(), result.appartement());
        assertEquals(address.number(), result.number());
        assertEquals(address.building(), result.building());
        assertEquals(address.street(), result.street());
        assertEquals(address.county(), result.county());
        assertEquals(new CountryDto(), result.country());
    }

    @Test
    void toDto_returns_nullAddressDto() {
        // GIVEN
        AddressMapper addressMapper = new AddressMapper();

        // WHEN
        AddressDto result = addressMapper.toDto(null);

        // THEN
        assertNull( result.id());
        assertNull( result.appartement());
        assertNull( result.number());
        assertNull( result.building());
        assertNull( result.street());
        assertNull( result.county());
        assertNull( result.country());
    }
}