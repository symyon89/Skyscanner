package service;

import dto.AddressDto;
import dto.CountryDto;
import model.Address;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.DefaultRepository;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;


public class AdressServiceTest {
    private DefaultRepository<Address> addressRepository = Mockito.mock(DefaultRepository.class);

    @Test
    void save_calls_repositorySave() {
        // GIVEN
        AddressDto addressDto = new AddressDto()
                .country(new CountryDto().id(1));
        AddressService addressService = new AddressService(addressRepository);

        // WHEN
        addressService.save(addressDto);

        // THEN
        Mockito.verify(addressRepository).save(any());

    }
}
