package com.example.libraryproject.exception.library;

import com.example.libraryproject.exception.general.ResourceExistsException;

public class LibraryExistsException extends ResourceExistsException {
    public LibraryExistsException(String message) {
        super(message);
    }
}
