package service;

import dto.PassengerDto;
import model.Passenger;

public class PassengerMapper {
    private AddressMapper addressMapper = new AddressMapper();

    public Passenger fromDto(PassengerDto passengerDto) {
        return new Passenger()
                .id(passengerDto.id())
                .address(addressMapper.fromDto(passengerDto.address()))
                .firstName(passengerDto.firstName())
                .lastName(passengerDto.lastName())
                .number(passengerDto.number())
                .series(passengerDto.series())
                .isInsured(passengerDto.isInsured())
                .phoneNumber(passengerDto.phoneNumber())
                .email(passengerDto.email());
    }

    public PassengerDto toDto(Passenger passenger) {
        return new PassengerDto()
                .id(passenger.id())
                .address(addressMapper.toDto(passenger.address()))
                .firstName(passenger.firstName())
                .lastName(passenger.lastName())
                .number(passenger.number())
                .series(passenger.series())
                .isInsured(passenger.isInsured())
                .phoneNumber(passenger.phoneNumber())
                .email(passenger.email());
    }
}
