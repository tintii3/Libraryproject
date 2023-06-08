package com.example.libraryproject.services.impl;

import com.example.libraryproject.domain.Address;
import com.example.libraryproject.domain.Student;
import com.example.libraryproject.exception.general.ResourceIllegalStateException;
import com.example.libraryproject.exception.student.StudentNotFoundException;
import com.example.libraryproject.repositories.StudentRepositories;
import com.example.libraryproject.services.StudentService;
import com.example.libraryproject.web.v1.dtos.student.CreateStudentDTO;
import com.example.libraryproject.web.v1.dtos.student.UpdateStudentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepositories studentRepositories;

    @Autowired
    public StudentServiceImpl(StudentRepositories studentRepositories) {
        this.studentRepositories = studentRepositories;
    }

    @Override
    public Collection<Student> getAllStudents() {
        return this.studentRepositories.findAll();
    }

    @Override
    public Student getStudent(Integer studentId) {
        return (Student) this.studentRepositories.findById(studentId).orElseThrow(() -> {
            return new StudentNotFoundException("Student not be found.");
        });
    }

    @Override
    public Student createStudent(CreateStudentDTO createStudentDTO) {
        Student newStudent = new Student();
        this.validateFirstNameAndLastName(createStudentDTO.getFirstName(), createStudentDTO.getLastName());
        BeanUtils.copyProperties(createStudentDTO, newStudent);
        if (createStudentDTO.hasAddress()){
            if (Objects.isNull(createStudentDTO.getAddress().getStreet()) || createStudentDTO.getAddress().getStreet().isEmpty()){
                throw new ResourceIllegalStateException("Street must be specified.");
            }
            if (Objects.isNull(createStudentDTO.getAddress().getCity()) || createStudentDTO.getAddress().getCity().isEmpty()){
                throw new ResourceIllegalStateException("City must be specified.");
            }
            if (Objects.isNull(createStudentDTO.getAddress().getCountry()) || createStudentDTO.getAddress().getCountry().isEmpty()){
                throw new ResourceIllegalStateException("Country must be specified.");
            }
            Address address = new Address();
            BeanUtils.copyProperties(createStudentDTO.getAddress(), address);
            newStudent.setAddress(address);
        }

        newStudent.activate();
        return (Student) studentRepositories.saveAndFlush(newStudent);
    }

    @Override
    public Student updateStudent(Integer studentId, UpdateStudentDTO updateStudentDTO) {
        Student student = this.getStudent(studentId);
        this.validateFirstNameAndLastName(student.getFirstName(), student.getLastName());
        BeanUtils.copyProperties(updateStudentDTO, student);
        return (Student) this.studentRepositories.saveAndFlush(student);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        this.studentRepositories.deleteById(studentId);
    }

    @Override
    public void activateStudent(Integer studentId) {
        Student student = this.getStudent(studentId);
        if (student.isActive()){
            throw new ResourceIllegalStateException("Student is already active.");
        } else {
            student.activate();
            this.studentRepositories.saveAndFlush(student);
        }
    }

    @Override
    public void deactivateStudent(Integer studentId) {
        Student student = this.getStudent(studentId);
        if (!student.isActive()){
            throw new ResourceIllegalStateException("Student is already deactive.");
        } else {
            student.deactivate();
            this.studentRepositories.saveAndFlush(student);
        }
    }

    private void validateFirstNameAndLastName(String firstName, String lastName) {
        if (!Objects.isNull(firstName) && !firstName.isEmpty()){
            if (Objects.isNull(lastName) || lastName.isEmpty()){
                throw new ResourceIllegalStateException("Last name must be specified.");
            }
        } else {
            throw new ResourceIllegalStateException("First name must be specified");
        }
    }

}
