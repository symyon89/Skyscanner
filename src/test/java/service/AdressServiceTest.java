package service;

import dto.AddressDto;
import model.Address;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.DefaultRepository;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;


class AdressServiceTest {
    private final DefaultRepository<Address> addressRepository = Mockito.mock(DefaultRepository.class);
    private final AddressService addressService = new AddressService(addressRepository);

    @Test
    void save_calls_repositorySave() {
        // GIVEN
        AddressDto addressDto = new AddressDto();

        // WHEN
        addressService.save(addressDto);

        // THEN
        Mockito.verify(addressRepository).save(any());

    }

    @Test
    void findAll_calls_repositoryFindAll() {
        // GIVEN

        // WHEN
        addressService.findAll();

        // THEN
        Mockito.verify(addressRepository).findAll(any());
    }

    @Test
    void findByID_calls_repositoryFindByID() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        addressService.findById(id);
        Mockito.when(addressService.findById(id)).thenReturn(new AddressDto());

        // THEN
        Mockito.verify(addressRepository).findById(id, Address.class);
    }

    @Test
    void remove_calls_removeRepository() {

        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        addressService.remove(id);

        // THEN
        Mockito.verify(addressRepository).removeById(id, Address.class);
    }

}
