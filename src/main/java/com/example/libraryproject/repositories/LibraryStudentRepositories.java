package com.example.libraryproject.repositories;

import com.example.libraryproject.domain.LibraryStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryStudentRepositories extends JpaRepository<LibraryStudent, Integer> {
}
