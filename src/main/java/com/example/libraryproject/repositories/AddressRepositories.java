package com.example.libraryproject.repositories;

import com.example.libraryproject.domain.Address;
import com.example.libraryproject.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepositories extends JpaRepository<Address, Integer> {
    Optional<Address> findAddressByStudent(Student student);
}
