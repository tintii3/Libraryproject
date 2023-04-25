package com.example.libraryproject.exception.library;

import com.example.libraryproject.exception.general.ResourceIllegalStateException;

public class LibraryUnassignedException extends ResourceIllegalStateException {
    public LibraryUnassignedException(String s) {
        super(s);
    }
}
