package model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@Accessors(fluent = true, chain = true)
public class Company {
    @Id
    @GeneratedValue(generator = "UUID2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 28)
    private String name;

    @Column(length = 10)
    private String code;
}
