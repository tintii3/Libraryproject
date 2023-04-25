package com.example.libraryproject.repositories;

import com.example.libraryproject.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositories extends JpaRepository<Student, Integer> {
}
