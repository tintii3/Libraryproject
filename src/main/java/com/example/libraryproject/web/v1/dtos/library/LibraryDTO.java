package com.example.libraryproject.web.v1.dtos.library;

import com.example.libraryproject.web.v1.dtos.book.BookDTO;
import com.example.libraryproject.web.v1.dtos.student.StudentDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibraryDTO {
    private Integer libraryId;
    private String name;
    private Boolean active;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Collection<StudentDTO> students;

}
