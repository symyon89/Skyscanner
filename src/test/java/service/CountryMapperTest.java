package service;

import dto.CountryDto;
import model.Country;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class CountryMapperTest {
    private static final int COUNTRY_ID = 1;
    private static final String COUNTRY_NAME = "Romania";
    private static final String COUNTRY_CODE = "Ro";


    @Test
    void fromDto_returns_modelCountry() {

        // GIVEN
        CountryMapper countryMapper = new CountryMapper();
        CountryDto countryDto = new CountryDto()
                .id(COUNTRY_ID)
                .countryCode(COUNTRY_CODE)
                .countryName(COUNTRY_NAME);
        Country requiredResult;

        // WHEN
        requiredResult = countryMapper.fromDto(countryDto);

        // THEN

        assertEquals(countryDto.id(),requiredResult.id());
        assertEquals(countryDto.countryCode(),requiredResult.countryCode());
        assertEquals(countryDto.countryName(),requiredResult.countryName());
    }
    @Test
    void fromDto_returns_nullModelCountry() {

        // GIVEN
        CountryMapper countryMapper = new CountryMapper();
        CountryDto countryDto = null;
        Country requiredResult;

        // WHEN
        requiredResult = countryMapper.fromDto(countryDto);

        // THEN

        assertEquals(null,requiredResult.id());
        assertEquals(null,requiredResult.countryCode());
        assertEquals(null,requiredResult.countryName());
    }

    @Test
    void toDto_returns_dtoCountry() {
        // GIVEN
        CountryMapper countryMapper = new CountryMapper();
        Country countryToTest = null;

        // WHEN
        CountryDto countryDto = countryMapper.toDto(countryToTest);

        // THEN

        assertEquals(null,countryDto.id());
        assertEquals(null,countryDto.countryName());
        assertEquals(null,countryDto.countryCode());
    }
}