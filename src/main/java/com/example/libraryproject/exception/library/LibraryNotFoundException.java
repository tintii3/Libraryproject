package com.example.libraryproject.exception.library;

import com.example.libraryproject.exception.general.ResourceNotFoundException;

public class LibraryNotFoundException extends ResourceNotFoundException {
    public LibraryNotFoundException(String message) {
        super(message);
    }
}
