package dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Data
public class AircraftDto {

    private UUID id;
    private String name;
    private int seats;
    private CompanyDto company;
}
