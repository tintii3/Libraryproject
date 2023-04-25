package com.example.libraryproject.repositories;

import com.example.libraryproject.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepositories extends JpaRepository<Location, Integer> {

}
