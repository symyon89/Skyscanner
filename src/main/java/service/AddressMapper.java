package service;

import dto.AddressDto;
import model.Address;

public class AddressMapper {
    private final CountryMapper countryMapper = new CountryMapper();

    public Address fromDto(AddressDto addressDto) {
        Address address = new Address()
                .appartement(addressDto.appartement())
                .id(addressDto.id())
                .street(addressDto.street())
                .number(addressDto.number())
                .building(addressDto.building())
                .city(addressDto.city())
                .county(addressDto.county());
        if(addressDto.country() != null){
            address.country(countryMapper.fromDto(addressDto.country()));
        }
        return address;
    }
    public AddressDto toDto(Address address) {
        AddressDto addressDto = new AddressDto()
                .appartement(address.appartement())
                .id(address.id())
                .street(address.street())
                .number(address.number())
                .building(address.building())
                .city(address.city())
                .county(address.county());
        if(address.country() != null) {
            addressDto.country(countryMapper.toDto(address.country()));
        }
        return addressDto;
    }
}
