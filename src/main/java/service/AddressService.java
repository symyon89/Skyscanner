package service;


import dto.AddressDto;
import lombok.Data;
import lombok.experimental.Accessors;
import model.Address;

import repository.DefaultRepository;


import java.util.List;
import java.util.stream.Collectors;


@Data
@Accessors(fluent = true, chain = true)
public class AddressService {
    private final DefaultRepository<Address> addressRepository = new DefaultRepository<>();

   public void save(AddressDto addressDto) {
        Address address = new Address();
        address.building(addressDto.getBuilding());
        address.street(addressDto.getStreet());
        address.city(addressDto.getCity());
        address.appartement(addressDto.getAppartement());
        address.county(addressDto.getCounty());
        address.id(addressDto.getId());
        //address.country(addressDto.getCountry()); rezolv eu TODO verific si sus

        addressRepository.save(address);
   }

   public List<AddressDto> findAll() {
       List<Address> address = addressRepository.findAll("from Address");
       return address.stream().map(a ->{
           AddressDto addressDto = new AddressDto();
            addressDto.setAppartement(a.appartement());
           return addressDto;
       }).collect(Collectors.toList());
   }



}
