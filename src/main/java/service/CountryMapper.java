package service;


import dto.CountryDto;
import model.Country;

public class CountryMapper {

    public Country fromDto(CountryDto countryDto) {
        return countryDto == null ? new Country() : new Country()
                .countryCode(countryDto.countryCode())
                .countryName(countryDto.countryName())
                .id(countryDto.id());
    }

    public CountryDto toDto(Country country) {
        return country == null ? new CountryDto() : new CountryDto()
                .countryCode(country.countryCode())
                .countryName(country.countryName())
                .id(country.id());
    }
}