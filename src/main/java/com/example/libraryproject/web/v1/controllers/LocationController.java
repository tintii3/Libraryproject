package com.example.libraryproject.web.v1.controllers;

import com.example.libraryproject.domain.Address;
import com.example.libraryproject.domain.Location;
import com.example.libraryproject.services.LocationService;
import com.example.libraryproject.utils.mappers.LocationMapper;
import com.example.libraryproject.web.v1.dtos.address.AddressDTO;
import com.example.libraryproject.web.v1.dtos.address.CreateAddressDTO;
import com.example.libraryproject.web.v1.dtos.address.UpdateAddressDTO;
import com.example.libraryproject.web.v1.dtos.location.CreateLocationDTO;
import com.example.libraryproject.web.v1.dtos.location.LocationDTO;
import com.example.libraryproject.web.v1.dtos.location.UpdateLocationDTO;
import com.example.libraryproject.web.v1.wrappers.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"/api/v1"})
public class LocationController {
    private final LocationService locationService;
    private final LocationMapper locationMapper;

    @Autowired
    public LocationController(LocationService locationService, LocationMapper locationMapper) {
        this.locationService = locationService;
        this.locationMapper = locationMapper;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/libraries/{libraryId}/location"})
    public ResponseEntity<ResponseWrapper<LocationDTO>> getLocationForLibrary(@PathVariable("libraryId") Integer libraryId){
        Location location = this.locationService.getLocationForLibrary(libraryId);
        LocationDTO locationDTO = this.locationMapper.toLocationDTO(location);
        return ResponseEntity.ok(new ResponseWrapper<>(locationDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = {"/libraries/{libraryId}/location"})
    public ResponseEntity<ResponseWrapper<LocationDTO>> createLocationForLibrary(@PathVariable("libraryId") Integer libraryId, @RequestBody CreateLocationDTO createLocationDTO){
        Location location = this.locationService.createLocationForLibrary(libraryId, createLocationDTO);
        LocationDTO locationDTO = this.locationMapper.toLocationDTO(location);
        return ResponseEntity.ok(new ResponseWrapper<>(locationDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = {"/libraries/{libraryId}/location"})
    public ResponseEntity<ResponseWrapper<LocationDTO>> updateLocationForLibrary(@PathVariable("libraryId") Integer libraryId, @RequestBody UpdateLocationDTO updateLocationDTO){
        Location location = this.locationService.updateLocationForLibrary(libraryId, updateLocationDTO);
        LocationDTO locationDTO = this.locationMapper.toLocationDTO(location);
        return ResponseEntity.ok(new ResponseWrapper<>(locationDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/libraries/{libraryId}/location"})
    public ResponseEntity<ResponseWrapper<Void>> deleteLocationForLibrary(@PathVariable("libraryId") Integer libraryId){
        this.locationService.deleteLocationForLibrary(libraryId);
        return ResponseEntity.noContent().build();
    }
    
}
