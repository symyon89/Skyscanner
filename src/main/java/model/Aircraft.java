package model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Aircraft {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;
    private int seats;

    @ManyToOne()
    @JoinTable(
            name = "company_aircraft",
            joinColumns =@JoinColumn(name = "company_id"),
            inverseJoinColumns =@JoinColumn(name = "aircraft_id")
    )
    private Company company;
}
