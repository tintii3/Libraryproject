package com.example.libraryproject.services.impl;

import com.example.libraryproject.domain.Address;
import com.example.libraryproject.domain.Library;
import com.example.libraryproject.domain.Location;
import com.example.libraryproject.exception.address.AddressExistsException;
import com.example.libraryproject.exception.general.ResourceIllegalStateException;
import com.example.libraryproject.exception.location.LocationExistsException;
import com.example.libraryproject.exception.location.LocationNotFoundException;
import com.example.libraryproject.repositories.LocationRepositories;
import com.example.libraryproject.services.LibraryService;
import com.example.libraryproject.services.LocationService;
import com.example.libraryproject.web.v1.dtos.location.CreateLocationDTO;
import com.example.libraryproject.web.v1.dtos.location.UpdateLocationDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LocationServiceImpl implements LocationService {
    private final LibraryService libraryService;
    private final LocationRepositories locationRepositories;

    @Autowired
    public LocationServiceImpl(LibraryService libraryService, LocationRepositories locationRepositories) {
        this.libraryService = libraryService;
        this.locationRepositories = locationRepositories;
    }

    @Override
    public Location getLocationForLibrary(Integer libraryId) {
        Library library = this.libraryService.getLibrary(libraryId);
        return (Location) this.locationRepositories.findLocationByLibrary(library).orElseThrow(() -> {
            throw new LocationNotFoundException("Location could not be found.");
        });
    }

    @Override
    public Location createLocationForLibrary(Integer libraryId, CreateLocationDTO createLocationDTO) {
        Library library = this.libraryService.getLibrary(libraryId);
        if (library.hasLocation()){
            throw new LocationExistsException("Location already exists for the specified library.");
        } else if (!Objects.isNull(createLocationDTO.getStreet()) && !createLocationDTO.getStreet().isEmpty()){
            if (!Objects.isNull(createLocationDTO.getCity()) && !createLocationDTO.getCity().isEmpty()){
                if (!Objects.isNull(createLocationDTO.getCountry()) && !createLocationDTO.getCountry().isEmpty()){
                    Location location = new Location();
                    BeanUtils.copyProperties(createLocationDTO, location);
                    library.setLocation(location);
                    return (Location) this.locationRepositories.saveAndFlush(location);
                } else {
                    throw new ResourceIllegalStateException("Country must be specified.");
                }
            } else {
                throw new ResourceIllegalStateException("City must be specified.");
            }
        }
        else {
            throw new ResourceIllegalStateException("Street must be specified.");
        }
    }

    @Override
    public Location updateLocationForLibrary(Integer libraryId, UpdateLocationDTO updateLocationDTO) {
        Library library = this.libraryService.getLibrary(libraryId);
        Location location = (Location) this.locationRepositories.findLocationByLibrary(library).orElseThrow(() -> {
            throw new LocationNotFoundException(("Location could not be found."));
        });
        if (!Objects.isNull(updateLocationDTO.getStreet()) && !updateLocationDTO.getStreet().isEmpty()){
            if (!Objects.isNull(updateLocationDTO.getCity()) && !updateLocationDTO.getCity().isEmpty()){
                if (!Objects.isNull(updateLocationDTO.getCountry()) && !updateLocationDTO.getCountry().isEmpty()){
                    BeanUtils.copyProperties(updateLocationDTO, location);
                    return (Location) this.locationRepositories.saveAndFlush(location);
                } else {
                    throw new ResourceIllegalStateException("Country must be specified.");
                }
            } else {
                throw new ResourceIllegalStateException("City must be specified.");
            }
        }
        else {
            throw new ResourceIllegalStateException("Street must be specified.");
        }
    }

    @Override
    public void deleteLocationForLibrary(Integer libraryId) {
        Library library = this.libraryService.getLibrary(libraryId);
        Location location = (Location) this.locationRepositories.findLocationByLibrary(library).orElseThrow(() -> {
            throw new LocationNotFoundException("Library doesn't have a location.");
        });
        library.unsetRelationship(location);
        this.locationRepositories.delete(location);
    }
}
