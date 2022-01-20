package dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(fluent = true, chain = true)
public class CountryDto {

    private Integer id;
    private Integer phoneCode;
    private String countryCode;
    private String countryName;


}