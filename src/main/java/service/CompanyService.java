package service;

import dto.CompanyDto;
import lombok.Data;
import model.Company;
import repository.DefaultRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class CompanyService {
    private DefaultRepository<Company> companyRepository;
    private CompanyMapper companyMapper = new CompanyMapper();

    public CompanyService() {
        this.companyRepository = new DefaultRepository<>();
    }

    public CompanyService(DefaultRepository<Company> companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void save (CompanyDto companyDto) {
        companyRepository.save(companyMapper.fromDto(companyDto));
    }

    public List<CompanyDto> findAll() {
        return companyRepository.findAll("from Company")
                .stream()
                .map(company -> companyMapper.toDto(company))
                .collect(Collectors.toList());
    }

    public CompanyDto findById(UUID id) {
        return companyMapper.toDto(companyRepository.findById(id, Company.class));
    }

    public void remove(UUID id) {
        companyRepository.removeById(id,Company.class);
    }

    public List<CompanyDto> findByName(String name) {
        return companyRepository.findBy("from Company","name", name)
                .stream()
                .map(company -> companyMapper.toDto(company))
                .collect(Collectors.toList());
    }

    public List<CompanyDto> findByCode(String code) {
        return companyRepository.findBy("from Company","code", code)
                .stream()
                .map(company -> companyMapper.toDto(company))
                .collect(Collectors.toList());
    }
}
