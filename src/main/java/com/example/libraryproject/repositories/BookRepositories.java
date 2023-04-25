package com.example.libraryproject.repositories;

import com.example.libraryproject.domain.Book;
import com.example.libraryproject.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepositories extends JpaRepository<Book, Integer> {
    Collection<Book> findAllByLibrary(Library library);
}
