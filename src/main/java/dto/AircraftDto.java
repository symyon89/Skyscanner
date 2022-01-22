package dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(fluent = true, chain = true)
public class AircraftDto {

    private UUID id;
    private String name;
    private int seats;
    private CompanyDto company;
}
