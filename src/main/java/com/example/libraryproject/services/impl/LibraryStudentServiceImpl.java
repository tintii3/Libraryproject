package com.example.libraryproject.services.impl;

import com.example.libraryproject.domain.Library;
import com.example.libraryproject.domain.Student;
import com.example.libraryproject.exception.general.ResourceIllegalStateException;
import com.example.libraryproject.exception.library.LibraryNotFoundException;
import com.example.libraryproject.exception.student.StudentNotFoundException;
import com.example.libraryproject.repositories.LibraryRepositories;
import com.example.libraryproject.repositories.StudentRepositories;
import com.example.libraryproject.services.LibraryStudentService;
import org.springframework.stereotype.Service;

@Service
public class LibraryStudentServiceImpl implements LibraryStudentService {
    private final LibraryRepositories libraryRepositories;
    private final StudentRepositories studentRepositories;

    public LibraryStudentServiceImpl(LibraryRepositories libraryRepositories, StudentRepositories studentRepositories) {
        this.libraryRepositories = libraryRepositories;
        this.studentRepositories = studentRepositories;
    }

    @Override
    public Library addStudentToLibrary(Integer libraryId, Integer studentId) {
        Library library = (Library) this.libraryRepositories.findById(libraryId).orElseThrow(() -> {
            throw new LibraryNotFoundException("Library could not be found");
        });
        Student student = (Student) this.studentRepositories.findById(studentId).orElseThrow(() -> {
            throw new StudentNotFoundException("Student could not be found");
        });
        if (library.hasStudent(studentId)){
            throw new ResourceIllegalStateException("Student is already assigned to this library.");
        } else {
            library.addStudent(student);
            return (Library) this.libraryRepositories.saveAndFlush(library);
        }
    }

    @Override
    public Library removeStudentFromLibrary(Integer libraryId, Integer studentId) {
        Library library = (Library) this.libraryRepositories.findById(libraryId).orElseThrow(() -> {
            throw new LibraryNotFoundException("Library could not be found.");
        });
        Student student = this.studentRepositories.findById(studentId).orElseThrow(() -> {
            throw new StudentNotFoundException("Student could not be found.");
        });
        if (!library.hasStudent(studentId)){
            throw new ResourceIllegalStateException("Student is not assigned to this library.");
        } else {
            library.removeStudent(student);
            return (Library) this.libraryRepositories.saveAndFlush(library);
        }
    }
}
