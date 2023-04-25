package com.example.libraryproject.exception.book;

import com.example.libraryproject.exception.general.ResourceIllegalStateException;

public class BookUnassignedException extends ResourceIllegalStateException {
    public BookUnassignedException(String s) {
        super(s);
    }
}
