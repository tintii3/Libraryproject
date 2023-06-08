package com.example.libraryproject.utils.mappers;

import com.example.libraryproject.domain.Address;
import com.example.libraryproject.web.v1.dtos.address.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDTO toAddressDTO(Address address) {
        return AddressDTO.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }
}
