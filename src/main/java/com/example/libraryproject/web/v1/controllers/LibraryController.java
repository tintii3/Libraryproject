package com.example.libraryproject.web.v1.controllers;

import com.example.libraryproject.domain.Library;
import com.example.libraryproject.services.LibraryService;
import com.example.libraryproject.services.LibraryStudentService;
import com.example.libraryproject.utils.mappers.LibraryMapper;
import com.example.libraryproject.web.v1.dtos.library.CreateLibraryDTO;
import com.example.libraryproject.web.v1.dtos.library.LibraryDTO;
import com.example.libraryproject.web.v1.dtos.library.UpdateLibraryDTO;
import com.example.libraryproject.web.v1.dtos.student.UpdateStudentDTO;
import com.example.libraryproject.web.v1.wrappers.ResponseWrapper;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = {"api/v1"})
public class LibraryController {
    private final LibraryService libraryService;
    private final LibraryMapper libraryMapper;
    private final LibraryStudentService libraryStudentService;

    public LibraryController(LibraryService libraryService, LibraryMapper libraryMapper, LibraryStudentService libraryStudentService) {
        this.libraryService = libraryService;
        this.libraryMapper = libraryMapper;
        this.libraryStudentService = libraryStudentService;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/libraries"}, produces = {"application/json"})
    public ResponseEntity<ResponseWrapper<Collection<LibraryDTO>>> getAllLibraries(){
        Collection<Library> libraries = this.libraryService.getAllLibraries();
        Collection<LibraryDTO> libraryDTOS = this.libraryMapper.toLibraryDTOS(libraries);
        return ResponseEntity.ok(new ResponseWrapper<>(libraryDTOS, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/libraries/{libraryId}"})
    public ResponseEntity<ResponseWrapper<LibraryDTO>> getLibrary(@PathVariable("libraryId") Integer libraryId){
        Library library = libraryService.getLibrary(libraryId);
        LibraryDTO libraryDTO = libraryMapper.toLibraryDTO(library);
        return ResponseEntity.ok(new ResponseWrapper<>(libraryDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = {"/libraries"}, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ResponseWrapper<LibraryDTO>> createLibrary(@RequestBody CreateLibraryDTO createLibraryDTO){
        Library createdLibrary = this.libraryService.createLibrary(createLibraryDTO);
        LibraryDTO createdLibraryDTO = this.libraryMapper.toLibraryDTO(createdLibrary);
        return ResponseEntity.ok(new ResponseWrapper<>(createdLibraryDTO, HttpStatus.CREATED.value()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = {"/libraries/{libraryId}"}, produces = "{application/json}", consumes = "{appliction/json}")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> updateLibrary(@PathVariable("LibraryId") Integer libraryId, @RequestBody UpdateLibraryDTO updateLibraryDTO){
        Library updatedLibrary = this.libraryService.updateLibrary(libraryId, updateLibraryDTO);
        LibraryDTO updatedLibraryDTO = this.libraryMapper.toLibraryDTO(updatedLibrary);
        return ResponseEntity.ok(new ResponseWrapper<>(updatedLibraryDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/libraries/{libraryId}"})
    public ResponseEntity<Void> deleteLibrary(@PathVariable("libraryId") Integer libraryId){
        this.libraryService.deleteLibrary(libraryId);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = {"/libraries/{libraryId}/activate"})
    public ResponseEntity<Void> activateLibrary(@PathVariable("LibraryId") Integer libraryId){
        this.libraryService.activateLibrary(libraryId);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = {"/libraries/{libraryId}/deactivate"})
    public ResponseEntity<Void> deactivateLibrary(@PathVariable("LibraryId") Integer libraryId){
        this.libraryService.deactivateLibrary(libraryId);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = {"/libraries/{libraryId}/students/{studentId}"})
    public ResponseEntity<ResponseWrapper<LibraryDTO>> addStudentToLibrary(@PathVariable("libraryId") Integer libraryId, @PathVariable("studentId") Integer studentId){
        Library library = this.libraryStudentService.addStudentToLibrary(libraryId, studentId);
        LibraryDTO libraryDTO = this.libraryMapper.toLibraryDTO(library);
        return ResponseEntity.ok(new ResponseWrapper<>(libraryDTO, HttpStatus.OK.value()));

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = {"/libraries/{libraryId}/students/{studentId}"})
    public ResponseEntity<ResponseWrapper<LibraryDTO>> removeStudentFromLibrary(@PathVariable("libraryId") Integer libraryId, @PathVariable("studentId") Integer studentId){
        Library library = this.libraryStudentService.removeStudentFromLibrary(libraryId, studentId);
        LibraryDTO libraryDTO = this.libraryMapper.toLibraryDTO(library);
        return ResponseEntity.ok(new ResponseWrapper<>(libraryDTO, HttpStatus.OK.value()));
    }

}
