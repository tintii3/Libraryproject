package com.example.libraryproject.services.impl;

import com.example.libraryproject.domain.Book;
import com.example.libraryproject.domain.Library;
import com.example.libraryproject.exception.book.BookNotFoundException;
import com.example.libraryproject.exception.general.ResourceIllegalStateException;
import com.example.libraryproject.exception.library.LibraryNotFoundException;
import com.example.libraryproject.repositories.BookRepositories;
import com.example.libraryproject.repositories.LibraryRepositories;
import com.example.libraryproject.services.BookService;
import com.example.libraryproject.web.v1.dtos.book.UpdateBookDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepositories bookRepositories;
    private final LibraryRepositories libraryRepositories;



    public BookServiceImpl(BookRepositories bookRepositories, LibraryRepositories libraryRepositories) {
        this.bookRepositories = bookRepositories;
        this.libraryRepositories = libraryRepositories;
    }

    @Override
    public Book getBook(Integer bookId) {
        return (Book) bookRepositories.findById(bookId).orElseThrow(() -> {
            return new BookNotFoundException("Book could not be found.");
        });
    }

    @Override
    public Collection<Book> getAllBooks() {
        return bookRepositories.findAll();
    }

    @Override
    public Book updateBook(Integer bookId, UpdateBookDTO updateBookDTO) {
        Book book = this.getBook(bookId);
        if (!Objects.isNull(updateBookDTO.getAuthor()) && !updateBookDTO.getAuthor().isEmpty()){
            if (!Objects.isNull(updateBookDTO.getTitle()) && !updateBookDTO.getTitle().isEmpty()){
                BeanUtils.copyProperties(updateBookDTO, book);
                return (Book) this.bookRepositories.saveAndFlush(book);
            } else {
                throw new ResourceIllegalStateException("Title must be specified");
            }
        } else {
            throw new ResourceIllegalStateException("Author must be specified");
        }
    }

    @Override
    public Collection<Book> getAllBooksForLibrary(Integer libraryId) {
        Library library = this.libraryRepositories.findById(libraryId).orElseThrow(() -> {
            return new LibraryNotFoundException("Library could not be found");
        });
        return library.getLibraryBooks();
    }

    @Override
    public void deleteBook(Integer bookId) {
        Book book = this.getBook(bookId);
        this.bookRepositories.delete(book);
    }
}
