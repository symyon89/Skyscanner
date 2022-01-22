package service;

import dto.PassengerDto;
import model.Passenger;

public class PassengerMapper {
    private final AddressMapper addressMapper = new AddressMapper();

    public Passenger fromDto(PassengerDto passengerDto) {
        Passenger passenger = new Passenger()
                .id(passengerDto.id())
                .firstName(passengerDto.firstName())
                .lastName(passengerDto.lastName())
                .number(passengerDto.number())
                .series(passengerDto.series())
                .isInsured(passengerDto.isInsured())
                .phoneNumber(passengerDto.phoneNumber())
                .email(passengerDto.email());
        if(passengerDto.address() != null) {
            passenger.address(addressMapper.fromDto(passengerDto.address()));
        }
        return passenger;
    }

    public PassengerDto toDto(Passenger passenger) {
        PassengerDto passengerDto = new PassengerDto()
                .id(passenger.id())
                .firstName(passenger.firstName())
                .lastName(passenger.lastName())
                .number(passenger.number())
                .series(passenger.series())
                .isInsured(passenger.isInsured())
                .phoneNumber(passenger.phoneNumber())
                .email(passenger.email());
        if(passengerDto.address() != null) {
            passengerDto.address(addressMapper.toDto(passenger.address()));
        }
        return passengerDto;
    }
}
