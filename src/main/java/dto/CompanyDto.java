package dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(fluent = true, chain = true)
public class CompanyDto {

    private UUID id;
    private String name;
    private String code;
}
