import dto.CompanyDto;
import dto.CountryDto;
import service.CompanyService;
import service.CountryService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.code("TAR").name("Tarom");
        CompanyService companyService = new CompanyService();
        //companyService.save(companyDto);
        List<CompanyDto> companies = companyService.findByName("Tar");
        companies.forEach(System.out::println);

        CountryDto countryDto = new CountryDto()
                .phoneCode(40)
                .countryName("Romania")
                .countryCode("Rom");
        CountryService countryService = new CountryService();
        //companyService.save(companyDto);

        //countryService.save(countryDto);
        countryService.findByName("Roma").forEach(System.out::println);



    }
}
