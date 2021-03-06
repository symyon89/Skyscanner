package dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalTime;
import java.util.UUID;

@Data
@Accessors(fluent = true, chain = true)
public class FlightDto {

    private UUID id;
    private AirportDto departure;
    private AirportDto arrival;
    private AircraftDto aircraft;
    private String code;
    private Integer distance;
    private LocalTime departureDate;
    private LocalTime arrivalDate;
}
