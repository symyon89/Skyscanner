package service;

import dto.AirportDto;
import dto.FlightDto;
import model.Airport;
import model.Flight;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.DefaultRepository;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

class FlightServiceTest {
    private final DefaultRepository<Flight> flightRepository = Mockito.mock(DefaultRepository.class);
    private final FlightService flightService = new FlightService(flightRepository);

    @Test
    void save_calls_repositorySave() {
        // GIVEN
        FlightDto flightDto = new FlightDto();

        // WHEN
        flightService.save(flightDto);

        // THEN
        Mockito.verify(flightRepository).save(any());
    }

    @Test
    void findAll_calls_repositoryFindAll() {
        // GIVEN

        // WHEN
        flightService.findAll();

        //THEN
        Mockito.verify(flightRepository).findAll("from Flight");
    }

    @Test
    void findByID_calls_repositoryFindByID() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        flightService.findById(id);

        // THEN
        Mockito.verify(flightRepository).findById(id, Flight.class);
    }

    @Test
    void remove_calls_removeRepository() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        flightService.remove(id);

        // THEN
        Mockito.verify(flightRepository).removeById(id, Flight.class);
    }

    @Test
    void findByCode_calls_repositoryFindBy() {
        // GIVEN
        String code = "code";

        // WHEN
        flightService.findByCode(code);

        // THEN
        Mockito.verify(flightRepository).findBy("from Flight","code",code);
    }
}