package service;

import dto.AircraftDto;
import model.Aircraft;

public class AircraftMapper {
    private final CompanyMapper companyMapper = new CompanyMapper();

    public Aircraft fromDto(AircraftDto aircraftDto) {
        Aircraft aircraft =  new Aircraft()
                .id(aircraftDto.id())
                .name(aircraftDto.name())
                .seats(aircraftDto.seats());
        if(aircraftDto.company() != null) {
            aircraft.company(companyMapper.fromDto(aircraftDto.company()));
        }
        return aircraft;
    }

    public AircraftDto toDto(Aircraft aircraft) {
        AircraftDto aircraftDto = new AircraftDto()
                .id(aircraft.id())
                .name(aircraft.name())
                .seats(aircraft.seats());
        if (aircraftDto.company() != null){
            aircraftDto.company(companyMapper.toDto(aircraft.company()));
        }
        return aircraftDto;

    }
}
