package model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Accessors(fluent = true, chain = true)
public class Passenger {
    @Id
    @GeneratedValue(generator = "UUID2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    private String firstName;
    private String lastName;

    @Column(length =20, nullable = false)
    private String number;

    @Column(length = 20)
    private String series;

    @Column(name = "isInsured", columnDefinition = "boolean default false")
    private boolean isInsured;

    @Column(name = "phone_number",length =15)
    private String phoneNumber;

    @Column(length =30)
    private String email;
}
