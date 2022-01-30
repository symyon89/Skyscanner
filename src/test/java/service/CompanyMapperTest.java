package service;

import dto.CompanyDto;
import model.Company;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CompanyMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final String TESTSTRING = "test";

    @Test
    void fromDto_returns_modelCompany() {

        // GIVEN
        CompanyMapper companyMapper = new CompanyMapper();
        CompanyDto companyDto = new CompanyDto()
                .id(ID)
                .name(TESTSTRING)
                .code(TESTSTRING);

        // WHEN
        Company result = companyMapper.fromDto(companyDto);

        // THEN
        assertEquals(companyDto.id(), result.id());
        assertEquals(companyDto.name(), result.name());
        assertEquals(companyDto.code(), result.code());
    }

    @Test
    void fromDto_returns_nullModelCompany() {

        // GIVEN
        CompanyMapper companyMapper = new CompanyMapper();

        // WHEN
        Company result = companyMapper.fromDto(null);

        // THEN
        assertNull(result.id());
        assertNull(result.name());
        assertNull(result.code());
    }

    @Test
    void toDto_returns_CompanyDto() {
        // GIVEN
        CompanyMapper companyMapper = new CompanyMapper();
        Company company = new Company()
                .id(ID)
                .name(TESTSTRING)
                .code(TESTSTRING);

        // WHEN
        CompanyDto result = companyMapper.toDto(company);

        // THEN
        assertEquals(company.id(), result.id());
        assertEquals(company.name(), result.name());
        assertEquals(company.code(), result.code());
    }

    @Test
    void toDto_returns_nullCompanyDto() {
        // GIVEN
        CompanyMapper companyMapper = new CompanyMapper();


        // WHEN
        CompanyDto result = companyMapper.toDto(null);

        // THEN
        assertNull(result.id());
        assertNull(result.name());
        assertNull(result.code());
    }
}