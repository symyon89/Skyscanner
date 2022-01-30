package service;

import dto.CompanyDto;
import model.Company;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.DefaultRepository;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

class CompanyServiceTest {
    private final DefaultRepository<Company> companyRepository = Mockito.mock(DefaultRepository.class);
    private final CompanyService companyService = new CompanyService(companyRepository);
    @Test
    void save_calls_repositorySave() {
        // GIVEN
        CompanyDto companyDto = new CompanyDto();

        // WHEN
        companyService.save(companyDto);

        // THEN
        Mockito.verify(companyRepository).save(any());
    }

    @Test
    void findAll_calls_repositoryFindAll() {
        // GIVEN

        // WHEN
        companyService.findAll();

        //THEN
        Mockito.verify(companyRepository).findAll("from Company");
    }

    @Test
    void findByID_calls_repositoryFindByID() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        companyService.findById(id);

        // THEN
        Mockito.verify(companyRepository).findById(id, Company.class);
    }

    @Test
    void remove_calls_removeRepository() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        companyService.remove(id);

        // THEN
        Mockito.verify(companyRepository).removeById(id, Company.class);
    }

    @Test
    void findByName_calls_repositoryFindBy() {
        // GIVEN
        String name = "name";

        // WHEN
        companyService.findByName(name);

        // THEN
        Mockito.verify(companyRepository).findBy("from Company","name",name);
    }

    @Test
    void findByCode() {
        // GIVEN
        String code = "code";

        // WHEN
        companyService.findByCode(code);

        // THEN
        Mockito.verify(companyRepository).findBy("from Company","code",code);
    }
}