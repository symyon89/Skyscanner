package service;

import dto.CountryDto;
import lombok.Data;
import model.Country;
import repository.DefaultRepository;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CountryService {
    private DefaultRepository<Country> countryRepository;
    private CountryMapper countryMapper = new CountryMapper();

    public CountryService() {
        this.countryRepository = new DefaultRepository<>();
    }

    public CountryService(DefaultRepository<Country> countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void save(CountryDto countryDto) {
        countryRepository.save(countryMapper.fromDto(countryDto));
    }

    public List<CountryDto> findAll () {
        return countryRepository.findAll("from Country")
                .stream()
                .map(country -> countryMapper.toDto(country))
                .collect(Collectors.toList());
    }

    public CountryDto findById(int id) {
        return countryMapper.toDto(countryRepository.findById(id,Country.class));
    }

    public void remove(int id) {
        countryRepository.removeById(id,Country.class);
    }

    public List<CountryDto> findByName(String name) {
        return countryRepository.findBy("from Country","countryName", name)
                .stream()
                .map(country -> countryMapper.toDto(country))
                .collect(Collectors.toList());
    }

    public List<CountryDto> findByCode(String code) {
        return countryRepository.findBy("from Country","countryCode", code)
                .stream()
                .map(country -> countryMapper.toDto(country))
                .collect(Collectors.toList());
    }
}
