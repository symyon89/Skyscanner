package model;

import lombok.Data;
import lombok.experimental.Accessors;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Accessors(fluent = true, chain = true)
public class Address {
    @Id
    @GeneratedValue(generator = "UUID2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 64)
    private String street;

    @Column(length = 10)
    private String number;

    @Column(length = 5)
    private String building;

    @Column(length = 5)
    private String appartement;

    @Column(length = 32)
    private String city;

    @Column(length = 32)
    private String county;

    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;


}
