import model.Address;
import model.Country;
import repository.DefaultRepository;
import service.AddressService;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class Main {
    public static void main(String[] args) {
        DefaultRepository<Country> countryRepository = new DefaultRepository<>();
        countryRepository.findAll("from Country").forEach(System.out::println);



    }
}
