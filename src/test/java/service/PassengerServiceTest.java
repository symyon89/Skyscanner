package service;

import dto.PassengerDto;
import model.Passenger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.DefaultRepository;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

class PassengerServiceTest {
    private final DefaultRepository<Passenger> passengerRepository = Mockito.mock(DefaultRepository.class);
    private final PassengerService passengerService = new PassengerService(passengerRepository);
    @Test
    void save_calls_repositorySave() {
        // GIVEN
        PassengerDto passengerDto = new PassengerDto();

        // WHEN
        passengerService.save(passengerDto);

        // THEN
        Mockito.verify(passengerRepository).save(any());
    }

    @Test
    void findAll_calls_repositoryFindAll() {
        // GIVEN

        // WHEN
        passengerService.findAll();

        //THEN
        Mockito.verify(passengerRepository).findAll("from Passenger");
    }

    @Test
    void findByID_calls_repositoryFindByID() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        passengerService.findById(id);

        // THEN
        Mockito.verify(passengerRepository).findById(id,Passenger.class);
    }

    @Test
    void remove_calls_removeRepository() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        passengerService.remove(id);

        // THEN
        Mockito.verify(passengerRepository).removeById(id, Passenger.class);
    }

    @Test
    void findByNumber_calls_repositoryFindBy() {
        // GIVEN
        String number = "number";

        // WHEN
        passengerService.findByNumber(number);

        // THEN
        Mockito.verify(passengerRepository).findBy("from Passenger","number",number);
    }

    @Test
    void findBySeries_calls_repositoryFindBy() {
        // GIVEN
        String series = "series";

        // WHEN
        passengerService.findBySeries(series);

        // THEN
        Mockito.verify(passengerRepository).findBy("from Passenger","series",series);
    }

    @Test
    void findByPhone_calls_repositoryFindBy() {
        // GIVEN
        String phone = "phone";

        // WHEN
        passengerService.findByPhone(phone);

        // THEN
        Mockito.verify(passengerRepository).findBy("from Passenger","phoneNumber",phone);
    }

    @Test
    void findByEmail_calls_repositoryFindBy() {
        // GIVEN
        String email = "email";

        // WHEN
        passengerService.findByEmail(email);

        // THEN
        Mockito.verify(passengerRepository).findBy("from Passenger","email",email);
    }
}