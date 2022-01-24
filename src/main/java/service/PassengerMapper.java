package service;

import dto.PassengerDto;
import model.Passenger;

public class PassengerMapper {
    private final AddressMapper addressMapper = new AddressMapper();

    public Passenger fromDto(PassengerDto passengerDto) {
        return passengerDto == null ? new Passenger() : new Passenger()
                .id(passengerDto.id())
                .firstName(passengerDto.firstName())
                .lastName(passengerDto.lastName())
                .number(passengerDto.number())
                .series(passengerDto.series())
                .isInsured(passengerDto.isInsured())
                .phoneNumber(passengerDto.phoneNumber())
                .email(passengerDto.email())
                .address(addressMapper.fromDto(passengerDto.address()));
    }

    public PassengerDto toDto(Passenger passenger) {
        return passenger == null ? new PassengerDto() : new PassengerDto()
                .id(passenger.id())
                .firstName(passenger.firstName())
                .lastName(passenger.lastName())
                .number(passenger.number())
                .series(passenger.series())
                .isInsured(passenger.isInsured())
                .phoneNumber(passenger.phoneNumber())
                .email(passenger.email())
                .address(addressMapper.toDto(passenger.address()));

    }
}
