package model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Country {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "phone_code", nullable = false)
    private Integer phoneCode;

    @Column(name = "country_code", nullable = false, length = 2)
    private String countryCode;

    @Column(name = "country_name", nullable = false, length = 80)
    private String countryName;


}