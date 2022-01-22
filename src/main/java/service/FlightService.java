package service;

import dto.FlightDto;
import lombok.Data;
import model.Flight;
import repository.DefaultRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class FlightService {
    private DefaultRepository<Flight> flightRepository;
    private FlightMapper flightMapper = new FlightMapper();

    public FlightService() {
        this.flightRepository = new DefaultRepository<>();
    }

    public FlightService(DefaultRepository<Flight> flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void save(FlightDto flightDto) {
        flightRepository.save(flightMapper.fromDto(flightDto));
    }

    public List<FlightDto> findAll() {
        return flightRepository.findAll("from Flight")
                .stream()
                .map(flight -> flightMapper.toDto(flight))
                .collect(Collectors.toList());
    }

    public FlightDto findById(UUID id) {
        return flightMapper.toDto(flightRepository.findById(id,Flight.class));
    }
    public void remove(UUID id) {
        flightRepository.removeById(id,Flight.class);
    }

    public List<FlightDto> findByCode(String code) {
        return flightRepository.findBy("from Flight","code", code)
                .stream()
                .map(flight -> flightMapper.toDto(flight))
                .collect(Collectors.toList());
    }

}
