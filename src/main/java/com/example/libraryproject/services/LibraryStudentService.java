package com.example.libraryproject.services;

import com.example.libraryproject.domain.Library;

public interface LibraryStudentService {
    Library removeStudentFromLibrary(Integer libraryId, Integer studentId);

    Library addStudentToLibrary(Integer libraryId, Integer studentId);
}
