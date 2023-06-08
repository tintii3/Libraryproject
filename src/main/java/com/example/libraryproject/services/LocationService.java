package com.example.libraryproject.services;

import com.example.libraryproject.domain.Location;
import com.example.libraryproject.web.v1.dtos.location.CreateLocationDTO;
import com.example.libraryproject.web.v1.dtos.location.UpdateLocationDTO;
import org.springframework.stereotype.Service;

public interface LocationService {
    Location getLocationForLibrary(Integer libraryId);

    Location createLocationForLibrary(Integer sudentId, CreateLocationDTO createLocationDTO);

    Location updateLocationForLibrary(Integer libraryId, UpdateLocationDTO updateLocationDTO);

    void deleteLocationForLibrary(Integer libraryId);
}
