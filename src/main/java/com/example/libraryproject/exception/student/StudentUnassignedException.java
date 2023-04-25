package com.example.libraryproject.exception.student;

import com.example.libraryproject.exception.general.ResourceIllegalStateException;

public class StudentUnassignedException extends ResourceIllegalStateException {
    public StudentUnassignedException(String s) {
        super(s);
    }
}
