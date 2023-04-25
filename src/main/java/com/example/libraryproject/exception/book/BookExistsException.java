package com.example.libraryproject.exception.book;

import com.example.libraryproject.exception.general.ResourceExistsException;

public class BookExistsException extends ResourceExistsException {
    public BookExistsException(String message) {
        super(message);
    }
}
