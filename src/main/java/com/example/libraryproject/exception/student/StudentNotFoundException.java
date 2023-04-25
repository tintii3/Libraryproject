package com.example.libraryproject.exception.student;

import com.example.libraryproject.exception.general.ResourceNotFoundException;

public class StudentNotFoundException extends ResourceNotFoundException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
