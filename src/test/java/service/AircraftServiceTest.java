package service;

import dto.AircraftDto;
import model.Aircraft;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.DefaultRepository;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

class AircraftServiceTest {
    private final DefaultRepository<Aircraft> aircraftRepository = Mockito.mock(DefaultRepository.class);
    private final AircraftService aircraftService = new AircraftService(aircraftRepository);
    @Test
    void save_calls_repositorySave() {
        // GIVEN
        AircraftDto aircraftDto = new AircraftDto();

        // WHEN
        aircraftService.save(aircraftDto);

        // THEN
        Mockito.verify(aircraftRepository).save(any());
    }

    @Test
    void findAll_calls_repositoryFindAll() {
        // GIVEN

        // WHEN
        aircraftService.findAll();

        //THEN
        Mockito.verify(aircraftRepository).findAll("from Aircraft");
    }

    @Test
    void findByID_calls_repositoryFindByID() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        aircraftService.findById(id);

        // THEN
        Mockito.verify(aircraftRepository).findById(id,Aircraft.class);
    }

    @Test
    void findByName_calls_repositoryFindBy() {
        // GIVEN
        String name = "name";

        // WHEN
        aircraftService.findByName(name);

        // THEN
        Mockito.verify(aircraftRepository).findBy("from Aircraft","name",name);
    }

    @Test
    void remove_calls_removeRepository() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        aircraftService.remove(id);

        // THEN
        Mockito.verify(aircraftRepository).removeById(id, Aircraft.class);
    }
}