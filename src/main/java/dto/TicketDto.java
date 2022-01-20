package dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Data
public class TicketDto {

    private UUID id;
    private PassengerDto passenger;
    private String seat;
    private String code;
    private FlightDto flight;

}
