package com.example.libraryproject.web.v1.dtos.student;

import com.example.libraryproject.web.v1.dtos.address.CreateAddressDTO;
import lombok.*;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private CreateAddressDTO address;
    public boolean hasAddress(){
        return Objects.nonNull(address);
    }
}
