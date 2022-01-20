package dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Data
public class AddressDto {

    private UUID id;
    private String street;
    private String number;
    private String building;
    private String appartement;
    private String city;
    private String county;
    private CountryDto country;


}
