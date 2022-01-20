package service;


import dto.AddressDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import model.Address;

import repository.DefaultRepository;


import java.util.List;
import java.util.stream.Collectors;


@Data
@Accessors(fluent = true, chain = true)
public class AddressService {
    private DefaultRepository<Address> addressRepository;
    private CountryMapper countryMapper = new CountryMapper();

    public AddressService() {
        this.addressRepository = new DefaultRepository<>();
    }

    public AddressService(DefaultRepository<Address> addressRepository) {
        this.addressRepository = addressRepository;
    }

   public void save(AddressDto addressDto) {
        Address address = new Address();
        address.building(addressDto.building());
        address.street(addressDto.street());
        address.city(addressDto.city());
        address.appartement(addressDto.appartement());
        address.county(addressDto.county());
        address.id(addressDto.id());
        address.country(countryMapper.fromDto(addressDto.country()));
        addressRepository.save(address);
   }

   public List<AddressDto> findAll() {
       List<Address> address = addressRepository.findAll("from Address");
       return address.stream().map(a ->{
           AddressDto addressDto = new AddressDto();
            addressDto.appartement(a.appartement());
           return addressDto;
       }).collect(Collectors.toList());
   }



}
