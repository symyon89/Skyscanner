package model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Data
@Accessors(fluent = true, chain = true)
public class Airport {
    @Id
    @GeneratedValue(generator = "UUID2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 64)
    private String name;

    @Column(length = 64)
    private String city;

    @Column(length = 10)
    private String code;

    private int airstrips;
    private int gates;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

}
