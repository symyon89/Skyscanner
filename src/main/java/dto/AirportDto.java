package dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Data
public class AirportDto {

    private UUID id;
    private String name;
    private String city;
    private String code;
    private int airstrips;
    private int gates;
    private AddressDto address;

}
