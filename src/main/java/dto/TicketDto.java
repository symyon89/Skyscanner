package dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(fluent = true, chain = true)
public class TicketDto {

    private UUID id;
    private PassengerDto passenger;
    private String seat;
    private String code;
    private FlightDto flight;

}
