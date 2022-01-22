package service;

import dto.AirportDto;
import model.Airport;

public class AirportMapper {
    private final AddressMapper addressMapper = new AddressMapper();

    public Airport fromDto(AirportDto airportDto) {
        Airport airport = new Airport()
                .id(airportDto.id())
                .name(airportDto.name())
                .city(airportDto.city())
                .code(airportDto.code())
                .airstrips(airportDto.airstrips())
                .gates(airportDto.gates());
        if(airportDto.address() != null) {
            airport.address(addressMapper.fromDto(airportDto.address()));
        }
        return airport;
    }

    public AirportDto toDto(Airport airport) {
        AirportDto airportDto = new AirportDto()
                .id(airport.id())
                .name(airport.name())
                .city(airport.city())
                .code(airport.code())
                .airstrips(airport.airstrips())
                .gates(airport.gates());
        if (airport.address() != null) {
            airportDto.address(addressMapper.toDto(airport.address()));
        }
        return airportDto;
    }
}
