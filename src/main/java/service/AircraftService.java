package service;

import dto.AircraftDto;
import lombok.Data;
import model.Aircraft;
import repository.DefaultRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class AircraftService {
    private DefaultRepository<Aircraft> aircraftRepository;
    private AircraftMapper aircraftMapper = new AircraftMapper();

    public AircraftService() {
        this.aircraftRepository =  new DefaultRepository<>();
    }

    public AircraftService(DefaultRepository<Aircraft> aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public void save(AircraftDto aircraftDto) {
        aircraftRepository.save(aircraftMapper.fromDto(aircraftDto));
    }

    public List<AircraftDto> findAll() {
        return aircraftRepository.findAll("from Aircraft")
                .stream()
                .map(aircraft -> aircraftMapper.toDto(aircraft))
                .collect(Collectors.toList());
    }

    public AircraftDto findById(UUID id) {
        return aircraftMapper.toDto(aircraftRepository.findById(id,Aircraft.class));
    }

    public List<AircraftDto> findByName(String name) {
        return aircraftRepository.findBy("from Aircraft","name",name)
                .stream()
                .map(aircraft -> aircraftMapper.toDto(aircraft))
                .collect(Collectors.toList());
    }

    public void remove(UUID id) {
        aircraftRepository.removeById(id,Aircraft.class);
    }

}
