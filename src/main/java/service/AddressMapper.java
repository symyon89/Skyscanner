package service;

import dto.AddressDto;
import model.Address;

public class AddressMapper {
    private CountryMapper countryMapper = new CountryMapper();

    public Address fromDto(AddressDto addressDto) {
        return new Address()
                .appartement(addressDto.appartement())
                .id(addressDto.id())
                .street(addressDto.street())
                .number(addressDto.number())
                .building(addressDto.building())
                .city(addressDto.city())
                .county(addressDto.county())
                .country(countryMapper.fromDto(addressDto.country()));
    }
    public AddressDto toDto(Address address) {
        return new AddressDto()
                .appartement(address.appartement())
                .id(address.id())
                .street(address.street())
                .number(address.number())
                .building(address.building())
                .city(address.city())
                .county(address.county())
                .country(countryMapper.toDto(address.country()));
    }
}
