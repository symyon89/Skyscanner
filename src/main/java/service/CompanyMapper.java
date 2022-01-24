package service;

import dto.CompanyDto;
import model.Company;

public class CompanyMapper {
    public Company fromDto(CompanyDto countryDto) {
        return (countryDto == null) ? new Company() : new Company()
                .id(countryDto.id())
                .name(countryDto.name())
                .code(countryDto.code());
    }

    public CompanyDto toDto(Company company) {
        return company == null ? new CompanyDto() : new CompanyDto()
                .id(company.id())
                .name(company.name())
                .code(company.code());
    }
}
