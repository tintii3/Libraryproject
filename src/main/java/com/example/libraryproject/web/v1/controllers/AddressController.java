package com.example.libraryproject.web.v1.controllers;

import com.example.libraryproject.domain.Address;
import com.example.libraryproject.domain.Student;
import com.example.libraryproject.services.AddressService;
import com.example.libraryproject.utils.mappers.AddressMapper;
import com.example.libraryproject.web.v1.dtos.address.AddressDTO;
import com.example.libraryproject.web.v1.dtos.address.CreateAddressDTO;
import com.example.libraryproject.web.v1.dtos.address.UpdateAddressDTO;
import com.example.libraryproject.web.v1.wrappers.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"/api/v1"})
public class AddressController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressController(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/student/{studentId}/address"})
    public ResponseEntity<ResponseWrapper<AddressDTO>> getAddressForStudent(@PathVariable("studentId") Integer studentId){
        Address address = this.addressService.getAddressForStudent(studentId);
        AddressDTO addressDTO = this.addressMapper.toAddressDTO(address);
        return ResponseEntity.ok(new ResponseWrapper<>(addressDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = {"/students/{studentId}/address"})
    public ResponseEntity<ResponseWrapper<AddressDTO>> createAddressForStudent(@PathVariable("studentId") Integer sudentId, @RequestBody CreateAddressDTO createAddressDTO){
        Address address = this.addressService.createAddressForStudent(sudentId, createAddressDTO);
        AddressDTO addressDTO = this.addressMapper.toAddressDTO(address);
        return ResponseEntity.ok(new ResponseWrapper<>(addressDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = {"/students/{studentId}/address"})
    public ResponseEntity<ResponseWrapper<AddressDTO>> updateAddressForStudent(@PathVariable("studentId") Integer studentId, @RequestBody UpdateAddressDTO updateAddressDTO){
        Address address = this.addressService.updateAddressForStudent(studentId, updateAddressDTO);
        AddressDTO addressDTO = this.addressMapper.toAddressDTO(address);
        return ResponseEntity.ok(new ResponseWrapper<>(addressDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/students/{studentId}/address"})
    public ResponseEntity<ResponseWrapper<Void>> deleteAddressForStudent(@PathVariable("studentId") Integer studentId){
        this.addressService.deleteAddressForStudent(studentId);
        return ResponseEntity.noContent().build();
    }
}
