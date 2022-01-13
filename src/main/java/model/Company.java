package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Company {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 28)
    private String name;

    @Column(length = 10)
    private String code;
}
