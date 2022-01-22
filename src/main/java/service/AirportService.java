package service;

import dto.AirportDto;
import lombok.Data;
import model.Airport;
import repository.DefaultRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Data
public class AirportService {
    private DefaultRepository<Airport> airportRepository;
    private AirportMapper airportMapper = new AirportMapper();

    public AirportService() {
        this.airportRepository = new DefaultRepository<>();
    }

    public AirportService(DefaultRepository<Airport> airportRepository) {
        this.airportRepository = airportRepository;
    }

    public void save(AirportDto airportDto) {
        airportRepository.save(airportMapper.fromDto(airportDto));
    }

    public List<AirportDto> findAll() {
        return airportRepository.findAll("from Airport")
                .stream()
                .map(airport -> airportMapper.toDto(airport))
                .collect(Collectors.toList());
    }

    public AirportDto findById(UUID id) {
        return airportMapper.toDto(airportRepository.findById(id,Airport.class));
    }
    public void remove(AirportDto airportDto) {
        airportRepository.remove(airportMapper.fromDto(airportDto));
    }

    public List<AirportDto> findByName(String name) {
        return airportRepository.findBy("from Airport","name", name)
                .stream()
                .map(airport -> airportMapper.toDto(airport))
                .collect(Collectors.toList());
    }

    public List<AirportDto> findByCity(String city) {
        return airportRepository.findBy("from Airport","city", city)
                .stream()
                .map(airport -> airportMapper.toDto(airport))
                .collect(Collectors.toList());
    }

    public List<AirportDto> findByCode(String code) {
        return airportRepository.findBy("from Airport","code", code)
                .stream()
                .map(airport -> airportMapper.toDto(airport))
                .collect(Collectors.toList());
    }

}
