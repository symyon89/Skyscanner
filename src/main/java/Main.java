import model.Address;
import model.Country;
import repository.DefaultRepository;

import java.util.UUID;


public class Main {
    public static void main(String[] args) {
        DefaultRepository<Country> countryRepository = new DefaultRepository<>();
        countryRepository.findAll("from Country").forEach(System.out::println);
        Address address = new Address();
        address.setId(UUID.randomUUID());
        address.setAppartement("7");
        address.setBuilding("B");
        address.setCity("Bucuresti2");
        address.setStreet("Calugareni");
        DefaultRepository<Address> addressRepository = new DefaultRepository<>();
        //addressRepository.save(address);
        Address a1 = addressRepository.findById(UUID.fromString("aecbe318-5ac2-4fda-94fb-3139d1bc08e0"),Address.class);
        System.out.println(a1.getBuilding());
    }
}
