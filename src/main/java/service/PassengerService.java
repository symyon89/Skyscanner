package service;

import dto.PassengerDto;
import lombok.Data;
import model.Passenger;
import repository.DefaultRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class PassengerService {
    private DefaultRepository<Passenger> passengerRepository;
    private PassengerMapper passengerMapper = new PassengerMapper();

    public PassengerService() {
        this.passengerRepository = new DefaultRepository<>();
    }

    public PassengerService(DefaultRepository<Passenger> passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public void save(PassengerDto passengerDto) {
        passengerRepository.save(passengerMapper.fromDto(passengerDto));
    }

    public List<PassengerDto> findAll() {
        return passengerRepository.findAll("from Passenger")
                .stream()
                .map(passenger -> passengerMapper.toDto(passenger))
                .collect(Collectors.toList());
    }

    public PassengerDto findById(UUID id) {
        return passengerMapper.toDto(passengerRepository.findById(id,Passenger.class));
    }

    public void remove(UUID id) {
        passengerRepository.removeById(id,Passenger.class);
    }

    public List<PassengerDto> findByNumber(String number) {
        return passengerRepository.findBy("from Passenger","number", number)
                .stream()
                .map(passenger -> passengerMapper.toDto(passenger))
                .collect(Collectors.toList());
    }

    public List<PassengerDto> findBySeries(String series) {
        return passengerRepository.findBy("from Passenger","series", series)
                .stream()
                .map(passenger -> passengerMapper.toDto(passenger))
                .collect(Collectors.toList());
    }

    public List<PassengerDto> findByPhone(String phoneNumber) {
        return passengerRepository.findBy("from Passenger","phoneNumber", phoneNumber)
                .stream()
                .map(passenger -> passengerMapper.toDto(passenger))
                .collect(Collectors.toList());
    }

    public List<PassengerDto> findByEmail(String email) {
        return passengerRepository.findBy("from Passenger","email", email)
                .stream()
                .map(passenger -> passengerMapper.toDto(passenger))
                .collect(Collectors.toList());
    }
}
