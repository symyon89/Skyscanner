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


}
