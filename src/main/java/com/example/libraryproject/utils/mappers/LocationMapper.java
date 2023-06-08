package com.example.libraryproject.utils.mappers;

import com.example.libraryproject.domain.Location;
import com.example.libraryproject.web.v1.dtos.location.LocationDTO;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    public LocationDTO toLocationDTO(Location location) {
        return LocationDTO.builder()
                .city(location.getCity())
                .country(location.getCountry())
                .street(location.getStreet())
                .build();
    }
}
