package com.example.libraryproject.exception.student;

import com.example.libraryproject.exception.general.ResourceExistsException;

public class StudentExistsException extends ResourceExistsException {
    public StudentExistsException(String message) {
        super(message);
    }
}
