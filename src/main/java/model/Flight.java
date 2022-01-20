package model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@Accessors(fluent = true, chain = true)
public class Flight {
    @Id
    @GeneratedValue(generator = "UUID2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airport departure;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airport arrival;

    @ManyToOne(cascade = CascadeType.ALL)
    private Aircraft aircraft;

    @Column(length = 13)
    private String code;

    private Integer distance;
    private LocalTime departureDate;
    private LocalTime arrivalDate;
}
