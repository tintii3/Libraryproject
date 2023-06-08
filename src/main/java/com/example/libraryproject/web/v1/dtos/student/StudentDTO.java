package com.example.libraryproject.web.v1.dtos.student;

import com.example.libraryproject.web.v1.dtos.address.AddressDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {

    private Integer studentId;
    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean isActive;
    private AddressDTO address;
}
