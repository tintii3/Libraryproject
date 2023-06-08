package com.example.libraryproject.services.impl;

import com.example.libraryproject.domain.Address;
import com.example.libraryproject.domain.Student;
import com.example.libraryproject.exception.address.AddressExistsException;
import com.example.libraryproject.exception.address.AddressNotFoundException;
import com.example.libraryproject.exception.general.ResourceIllegalStateException;
import com.example.libraryproject.repositories.AddressRepositories;
import com.example.libraryproject.repositories.StudentRepositories;
import com.example.libraryproject.services.AddressService;
import com.example.libraryproject.services.StudentService;
import com.example.libraryproject.web.v1.dtos.address.CreateAddressDTO;
import com.example.libraryproject.web.v1.dtos.address.UpdateAddressDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepositories addressRepositories;
    private final StudentService studentService;

    public AddressServiceImpl(AddressRepositories addressRepositories, StudentService studentService) {
        this.addressRepositories = addressRepositories;
        this.studentService = studentService;
    }

    @Override
    public Address getAddressForStudent(Integer studentId) {
        Student student = this.studentService.getStudent(studentId);
        return (Address) this.addressRepositories.findAddressByStudent(student).orElseThrow(() -> {
            return new AddressNotFoundException("Address could not be found.");
        });
    }

    @Override
    public Address createAddressForStudent(Integer studentId, CreateAddressDTO createAddressDTO) {
        Student student = this.studentService.getStudent(studentId);
        if (student.hasAddress()){
            throw new AddressExistsException("Address already exists for the specified student.");
        } else if (!Objects.isNull(createAddressDTO.getStreet()) && !createAddressDTO.getStreet().isEmpty()){
            if (!Objects.isNull(createAddressDTO.getCity()) && !createAddressDTO.getCity().isEmpty()){
                if (!Objects.isNull(createAddressDTO.getCountry()) && !createAddressDTO.getCountry().isEmpty()){
                    Address address = new Address();
                    BeanUtils.copyProperties(createAddressDTO, address);
                    student.setAddress(address);
                    return (Address) this.addressRepositories.saveAndFlush(address);
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
    public Address updateAddressForStudent(Integer studentId, UpdateAddressDTO updateAddressDTO) {
        Student student = this.studentService.getStudent(studentId);
        Address address = (Address) this.addressRepositories.findAddressByStudent(student).orElseThrow(() -> {
            throw new AddressNotFoundException("Address could not be found for the specified student.");
        });
        if (!Objects.isNull(updateAddressDTO.getStreet()) && !updateAddressDTO.getStreet().isEmpty()){
            if (!Objects.isNull(updateAddressDTO.getCity()) && !updateAddressDTO.getCity().isEmpty()){
                if (!Objects.isNull(updateAddressDTO.getCountry()) && !updateAddressDTO.getCountry().isEmpty()){
                    BeanUtils.copyProperties(updateAddressDTO, address);
                    return (Address) this.addressRepositories.saveAndFlush(address);
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
    public void deleteAddressForStudent(Integer studentId) {
        Student student = this.studentService.getStudent(studentId);
        Address address = (Address) this.addressRepositories.findAddressByStudent(student).orElseThrow(() -> {
            throw new AddressNotFoundException("Student doesn't have an address.");
        });
        student.unsetRelationship(address);
        this.addressRepositories.delete(address);
    }
}
