package service;


import dto.CountryDto;
import model.Country;

public class CountryMapper {

    public Country fromDto(CountryDto countryDto) {
        return new Country()
                .countryCode(countryDto.countryCode())
                .countryName(countryDto.countryName())
                .id(countryDto.id());
    }

    public CountryDto toDto(Country country) {
        return new CountryDto()
                .countryCode(country.countryCode())
                .countryName(country.countryName())
                .id(country.id());

    }
}