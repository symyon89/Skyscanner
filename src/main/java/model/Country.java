package model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Data
@Accessors(fluent = true, chain = true)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "phone_code", nullable = false)
    private Integer phoneCode;

    @Column(name = "country_code", nullable = false, length = 2)
    private String countryCode;

    @Column(name = "country_name", nullable = false, length = 80)
    private String countryName;


}