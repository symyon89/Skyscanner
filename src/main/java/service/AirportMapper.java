package service;

import dto.AirportDto;
import model.Airport;

public class AirportMapper {
    private final AddressMapper addressMapper = new AddressMapper();

    public Airport fromDto(AirportDto airportDto) {

        return airportDto == null ? new Airport() : new Airport()
                .id(airportDto.id())
                .name(airportDto.name())
                .city(airportDto.city())
                .code(airportDto.code())
                .airstrips(airportDto.airstrips())
                .gates(airportDto.gates())
                .address(addressMapper.fromDto(airportDto.address()));

    }

    public AirportDto toDto(Airport airport) {

        return airport == null ? new AirportDto() : new AirportDto()
                .id(airport.id())
                .name(airport.name())
                .city(airport.city())
                .code(airport.code())
                .airstrips(airport.airstrips())
                .gates(airport.gates())
                .address(addressMapper.toDto(airport.address()));
    }
}
