package com.example.libraryproject.web.v1.controllers;

import com.example.libraryproject.domain.Student;
import com.example.libraryproject.services.StudentService;
import com.example.libraryproject.utils.criteria.StudentCriteria;
import com.example.libraryproject.utils.mappers.StudentMapper;
import com.example.libraryproject.web.v1.dtos.student.CreateStudentDTO;
import com.example.libraryproject.web.v1.dtos.student.StudentDTO;
import com.example.libraryproject.web.v1.dtos.student.UpdateStudentDTO;
import com.example.libraryproject.web.v1.wrappers.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
//@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;
    @Autowired
    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/studentss"}, produces = {"application/json"})
    public ResponseEntity<ResponseWrapper<Collection<StudentDTO>>> getAllStudents(){
        Collection<Student> students = this.studentService.getAllStudents();
        Collection<StudentDTO> studentDTOS = this.studentMapper.toStudentDTOS(students);
        return ResponseEntity.ok(new ResponseWrapper<>(studentDTOS, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/students/{studentId}"}, produces = {"application/json"})
    public ResponseEntity<ResponseWrapper<StudentDTO>> getStudent(@PathVariable("studentId") Integer studentId, StudentCriteria studentCriteria){
        Student student = this.studentService.getStudent(studentId);
        StudentDTO studentDTO = this.studentMapper.toStudentDTO(student);
        return ResponseEntity.ok(new ResponseWrapper<>(studentDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = {"/students"}, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ResponseWrapper<StudentDTO>> createStudent(@RequestBody CreateStudentDTO createStudentDTO){
        Student createdStudent = this.studentService.createStudent(createStudentDTO);
        StudentDTO studentDTO = this.studentMapper.toStudentDTO(createdStudent);
        return ResponseEntity.ok(new ResponseWrapper<>(studentDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = {"/student/{studentId}"}, produces = {"application/json"}, consumes = {"apllication/json"})
    public ResponseEntity<ResponseWrapper<StudentDTO>> updateStudentDTO(@PathVariable("studentId") Integer studentId, @RequestBody UpdateStudentDTO updateStudentDTO){
        Student updatedStudent = this.studentService.updateStudent(studentId, updateStudentDTO);
        StudentDTO studentDTO = this.studentMapper.toStudentDTO(updatedStudent);
        return ResponseEntity.ok(new ResponseWrapper(updatedStudent, HttpStatus.OK.value()));

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/students/{studentsId}"})
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") Integer studentId){
        this.studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = {"/students/{studentId}/activate"})
    public ResponseEntity<Void> activateActor(@PathVariable("studentId") Integer studentId){
        this.studentService.activateStudent(studentId);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = {"/students/{studentId}/deactivate"})
    public ResponseEntity<Void> deactivateActor(@PathVariable("studentId") Integer studentId){
        this.studentService.deactivateStudent(studentId);
        return ResponseEntity.noContent().build();
    }
}
