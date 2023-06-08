package com.example.libraryproject.services;

import com.example.libraryproject.domain.Address;
import com.example.libraryproject.web.v1.dtos.address.CreateAddressDTO;
import com.example.libraryproject.web.v1.dtos.address.UpdateAddressDTO;
import org.springframework.stereotype.Service;


public interface AddressService {
    Address getAddressForStudent(Integer studentId);

    Address createAddressForStudent(Integer studentId, CreateAddressDTO createAddressDTO);

    Address updateAddressForStudent(Integer studentId, UpdateAddressDTO updateAddressDTO);

    void deleteAddressForStudent(Integer studentId);
}
