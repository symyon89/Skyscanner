package dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(fluent = true, chain = true)
public class AirportDto {

    private UUID id;
    private String name;
    private String city;
    private String code;
    private int airstrips;
    private int gates;
    private AddressDto address;

}
