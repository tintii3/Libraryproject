package com.example.libraryproject.web.v1.controllers;

import com.example.libraryproject.domain.Book;
import com.example.libraryproject.services.BookService;
import com.example.libraryproject.utils.mappers.BookMapper;
import com.example.libraryproject.web.v1.dtos.book.BookDTO;
import com.example.libraryproject.web.v1.dtos.book.UpdateBookDTO;
import com.example.libraryproject.web.v1.wrappers.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = {"/api/v1"})
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/books/{bookId}"}, produces = {"application/json"})
    public ResponseEntity<ResponseWrapper<BookDTO>> getBook(@PathVariable("bookId") Integer bookId){
        Book book = this.bookService.getBook(bookId);
        BookDTO bookDTO = this.bookMapper.toBookDTO(book);
        return ResponseEntity.ok(new ResponseWrapper(bookDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/books"}, produces = {"application/json"})
    public ResponseEntity<ResponseWrapper<Collection<BookDTO>>> getAllBooks(){
        Collection<Book> books = this.bookService.getAllBooks();
        Collection<BookDTO> bookDTOS = this.bookMapper.toBookDTOS(books);
        return ResponseEntity.ok(new ResponseWrapper<>(bookDTOS, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = {"/books/{bookId}"})
    public ResponseEntity<ResponseWrapper<BookDTO>> updateBook(@PathVariable("bookId") Integer bookId, @RequestBody UpdateBookDTO updateBookDTO){
        Book updatedBook = this.bookService.updateBook(bookId, updateBookDTO);
        BookDTO updatedBookDTO = this.bookMapper.toBookDTO(updatedBook);
        return ResponseEntity.ok(new ResponseWrapper(updatedBookDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/libraries/{libraryId}/books"})
    public ResponseEntity<ResponseWrapper<Collection<BookDTO>>> getAllBooksForLibrary(@PathVariable("libraryId") Integer libraryId){
        Collection<Book> books = this.bookService.getAllBooksForLibrary(libraryId);
        Collection<BookDTO> bookDTOS = this.bookMapper.toBookDTOS(books);
        return ResponseEntity.ok(new ResponseWrapper<>(bookDTOS, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/books/{bookId}"})
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Integer bookId) {
        this.bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }
}
