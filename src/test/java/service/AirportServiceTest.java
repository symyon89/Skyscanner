package service;

import dto.AirportDto;
import model.Airport;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.DefaultRepository;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

class AirportServiceTest {
    private final DefaultRepository<Airport> airportRepository = Mockito.mock(DefaultRepository.class);
    private final AirportService airportService = new AirportService(airportRepository);
    @Test
    void save_calls_repositorySave() {
        // GIVEN
        AirportDto airportDto = new AirportDto();

        // WHEN
        airportService.save(airportDto);

        // THEN
        Mockito.verify(airportRepository).save(any());
    }

    @Test
    void findAll_calls_repositoryFindAll() {
        // GIVEN

        // WHEN
        airportService.findAll();

        //THEN
        Mockito.verify(airportRepository).findAll("from Airport");
    }

    @Test
    void findByID_calls_repositoryFindByID() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        airportService.findById(id);

        // THEN
        Mockito.verify(airportRepository).findById(id,Airport.class);
    }

    @Test
    void remove_calls_removeRepository() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        airportService.remove(id);

        // THEN
        Mockito.verify(airportRepository).removeById(id, Airport.class);
    }

    @Test
    void findByName_calls_repositoryFindBy() {
        // GIVEN
        String name = "name";

        // WHEN
        airportService.findByName(name);

        // THEN
        Mockito.verify(airportRepository).findBy("from Airport","name",name);
    }

    @Test
    void findByCity_calls_repositoryFindBy() {
        // GIVEN
        String city = "city";

        // WHEN
        airportService.findByCity(city);

        // THEN
        Mockito.verify(airportRepository).findBy("from Airport","city",city);
    }

    @Test
    void findByCode_calls_repositoryFindBy() {
        // GIVEN
        String code = "code";

        // WHEN
        airportService.findByCode(code);

        // THEN
        Mockito.verify(airportRepository).findBy("from Airport","code",code);
    }
}