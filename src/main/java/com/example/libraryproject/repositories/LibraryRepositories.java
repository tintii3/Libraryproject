package com.example.libraryproject.repositories;

import com.example.libraryproject.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepositories extends JpaRepository<Library, Integer> {
}
