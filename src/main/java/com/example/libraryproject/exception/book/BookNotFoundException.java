package com.example.libraryproject.exception.book;

import com.example.libraryproject.exception.general.ResourceNotFoundException;

public class BookNotFoundException extends ResourceNotFoundException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
