package service;

import dto.AircraftDto;
import model.Aircraft;

public class AircraftMapper {
    private final CompanyMapper companyMapper = new CompanyMapper();

    public Aircraft fromDto(AircraftDto aircraftDto) {

        return aircraftDto == null ? new Aircraft() : new Aircraft()
                .id(aircraftDto.id())
                .name(aircraftDto.name())
                .seats(aircraftDto.seats())
                .company(companyMapper.fromDto(aircraftDto.company()));

    }

    public AircraftDto toDto(Aircraft aircraft) {

        return aircraft == null ? new AircraftDto() : new AircraftDto()
                .id(aircraft.id())
                .name(aircraft.name())
                .seats(aircraft.seats())
                .company(companyMapper.toDto(aircraft.company()));

    }
}
