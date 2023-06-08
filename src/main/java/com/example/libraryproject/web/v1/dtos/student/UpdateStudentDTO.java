package com.example.libraryproject.web.v1.dtos.student;

import com.example.libraryproject.web.v1.dtos.address.CreateAddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private CreateAddressDTO address;
}
