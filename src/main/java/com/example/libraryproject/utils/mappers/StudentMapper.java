package com.example.libraryproject.utils.mappers;

import com.example.libraryproject.domain.Student;
import com.example.libraryproject.utils.criteria.StudentCriteria;
import com.example.libraryproject.web.v1.dtos.student.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
public class StudentMapper {

    @Autowired
    private AddressMapper addressMapper;
    public Collection<StudentDTO> toStudentDTOS(Collection<Student> students, StudentCriteria studentCriteria) {
        if (Objects.isNull(studentCriteria)){
            return toStudentDTOS(students);
        }
        if (!studentCriteria.includeAddress()){
            return toStudentDTOS(students);
        }
        return toStudentDTOSWithAddress(students);
    }

    public Collection<StudentDTO> toStudentDTOS(Collection<Student> students) {
        return students.stream().map(this::toStudentDTO).collect(Collectors.toList());
    }

    public Collection<StudentDTO> toStudentDTOSWithAddress(Collection<Student> students) {
        return students.stream().map(this::toStudentDTOWithAddress).collect(Collectors.toList());
    }

    public  StudentDTO toStudentDTOWithAddress(Student student) {
        StudentDTO studentDTO = toStudentDTO(student);
        studentDTO.setAddress(student.hasAddress() ? addressMapper.toAddressDTO(student.getAddress()) : null);
        return studentDTO;
    }

    public StudentDTO toStudentDTO(Student student) {
        return StudentDTO.builder()
                .studentId(student.getStudentId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .isActive(student.isActive())
                .build();
    }
}
