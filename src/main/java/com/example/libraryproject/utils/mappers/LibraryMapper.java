package com.example.libraryproject.utils.mappers;

import com.example.libraryproject.domain.Library;
import com.example.libraryproject.utils.criteria.LibraryCriteria;
import com.example.libraryproject.web.v1.dtos.library.LibraryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class LibraryMapper {

    private final StudentMapper studentMapper;

    @Autowired
    public LibraryMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }



    public LibraryDTO toLibraryDTO(Library library){
        return LibraryDTO.builder()
                .libraryId(library.getLibraryId())
                .name(library.getLibraryName())
                .active(library.isActive())
                .build();
    }
    public LibraryDTO toLibraryDTO(Library library, LibraryCriteria libraryCriteria){
        if (libraryCriteria.includeStudent()){
            return toLibraryDTOWithStudents(library);
        }
        return toLibraryDTO(library);
    }

    private LibraryDTO toLibraryDTOWithStudents(Library library) {
        LibraryDTO libraryDTO = toLibraryDTO(library);
        libraryDTO.setStudents(studentMapper.toStudentDTOS(library.getAssignedStrdents()));
        return libraryDTO;
    }


    public Collection<LibraryDTO> toLibraryDTOS(Collection<Library> libraries) {
        return libraries.stream().map(this::toLibraryDTO)
                .collect(Collectors.toList());
    }
}
