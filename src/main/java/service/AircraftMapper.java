package service;

import dto.AircraftDto;
import model.Aircraft;

public class AircraftMapper {
    private CompanyMapper companyMapper = new CompanyMapper();

    public Aircraft fromDto(AircraftDto aircraftDto) {
        return new Aircraft()
                .id(aircraftDto.id())
                .name(aircraftDto.name())
                .seats(aircraftDto.seats())
                .company(companyMapper.fromDto(aircraftDto.company()));
    }

    public AircraftDto toDto(Aircraft aircraft) {
        return new AircraftDto()
                .id(aircraft.id())
                .name(aircraft.name())
                .seats(aircraft.seats())
                .company(companyMapper.toDto(aircraft.company()));
    }
}
