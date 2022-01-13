package model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Ticket {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Passenger passenger;

    @Column(length = 3)
    private String seat;

    @Column(length = 13)
    private String code;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "flight_ticket",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    private Flight flight;

}
