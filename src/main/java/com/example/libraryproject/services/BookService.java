package com.example.libraryproject.services;

import com.example.libraryproject.domain.Book;
import com.example.libraryproject.web.v1.dtos.book.UpdateBookDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface BookService {
    Book getBook(Integer bookId);

    Collection<Book> getAllBooks();

    Book updateBook(Integer bookId, UpdateBookDTO updateBookDTO);

    Collection<Book> getAllBooksForLibrary(Integer libraryId);

    void deleteBook(Integer bookId);
}
