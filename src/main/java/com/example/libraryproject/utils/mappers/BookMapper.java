package com.example.libraryproject.utils.mappers;

import com.example.libraryproject.domain.Book;
import com.example.libraryproject.web.v1.dtos.book.BookDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public BookDTO toBookDTO(Book book){
        return BookDTO.builder()
                .author(book.getAuthor())
                .title(book.getTitle())
                .build();
    }
    public Collection<BookDTO> toBookDTOS(Collection<Book> books){
        return books.stream().map(this::toBookDTO)
                .collect(Collectors.toList());
    }

}
