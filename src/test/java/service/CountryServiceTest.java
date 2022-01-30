package service;

import dto.AirportDto;
import dto.CompanyDto;
import dto.CountryDto;
import model.Airport;
import model.Country;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.DefaultRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class CountryServiceTest {
    private final DefaultRepository<Country> countryRepository = Mockito.mock(DefaultRepository.class);
    private final CountryService countryService = new CountryService(countryRepository);

    @Test
    void save_calls_repositorySave() {
        // GIVEN
        CountryDto companyDto = new CountryDto();

        // WHEN
        countryService.save(companyDto);

        // THEN
        Mockito.verify(countryRepository).save(any());
    }

    @Test
    void findAll_calls_repositoryFindAll() {
        // GIVEN

        // WHEN
        countryService.findAll();

        //THEN
        Mockito.verify(countryRepository).findAll("from Country");
    }

    @Test
    void findByID_calls_repositoryFindByID() {
        // GIVEN
        int id = 1;

        // WHEN
        countryService.findById(id);

        // THEN
        Mockito.verify(countryRepository).findById(id, Country.class);
    }

    @Test
    void remove_calls_removeRepository() {
        // GIVEN
        int id = 1;

        // WHEN
        countryService.remove(id);

        // THEN
        Mockito.verify(countryRepository).removeById(id, Country.class);
    }

    @Test
    void findByName_calls_repositoryFindBy() {
        // GIVEN
        String name = "name";

        // WHEN
        countryService.findByName(name);

        // THEN
        Mockito.verify(countryRepository).findBy("from Country","countryName",name);
    }

    @Test
    void findByCode_calls_repositoryFindBy() {
        // GIVEN
        String code = "code";

        // WHEN
        countryService.findByCode(code);

        // THEN
        Mockito.verify(countryRepository).findBy("from Country","countryCode",code);
    }
}