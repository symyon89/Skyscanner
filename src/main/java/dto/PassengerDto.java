package dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Data
@Accessors(fluent = true, chain = true)
public class PassengerDto {

    private UUID id;
    private AddressDto address;
    private String firstName;
    private String lastName;
    private String number;
    private String series;
    private boolean isInsured;
    private String phoneNumber;
    private String email;
}
