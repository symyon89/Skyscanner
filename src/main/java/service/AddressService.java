package service;


import dto.AddressDto;
import lombok.Data;
import lombok.experimental.Accessors;
import model.Address;

import repository.DefaultRepository;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Data
@Accessors(fluent = true, chain = true)
public class AddressService {
    private DefaultRepository<Address> addressRepository;
    private AddressMapper addressMapper = new AddressMapper();

    public AddressService() {
        this.addressRepository = new DefaultRepository<>();
    }

    public AddressService(DefaultRepository<Address> addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void save(AddressDto addressDto) {
        addressRepository.save(addressMapper.fromDto(addressDto));
    }

    public List<AddressDto> findAll() {
        List<Address> address = addressRepository.findAll("from Address");
        return address.stream()
                .map(a -> addressMapper.toDto(a))
                .collect(Collectors.toList());
    }

    public AddressDto findById(UUID id) {
        return addressMapper.toDto(addressRepository.findById(id,Address.class));
    }
    public void remove(UUID id) {
        addressRepository.removeById(id,Address.class);
    }
}
