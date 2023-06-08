package com.example.libraryproject.services;

import com.example.libraryproject.domain.Student;
import com.example.libraryproject.web.v1.dtos.student.CreateStudentDTO;
import com.example.libraryproject.web.v1.dtos.student.UpdateStudentDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;
public interface StudentService {

    Collection<Student> getAllStudents();

    Student getStudent(Integer studentId);

    Student createStudent(CreateStudentDTO createStudentDTO);

    Student updateStudent(Integer studentId, UpdateStudentDTO updateStudentDTO);

    void deleteStudent(Integer studentId);

    void activateStudent(Integer studentId);

    void deactivateStudent(Integer studentId);
}
