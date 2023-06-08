package com.example.libraryproject.services.impl;

import com.example.libraryproject.domain.Library;
import com.example.libraryproject.exception.general.ResourceIllegalStateException;
import com.example.libraryproject.exception.library.LibraryNotFoundException;
import com.example.libraryproject.repositories.LibraryRepositories;
import com.example.libraryproject.services.LibraryService;
import com.example.libraryproject.web.v1.dtos.library.CreateLibraryDTO;
import com.example.libraryproject.web.v1.dtos.library.LibraryDTO;
import com.example.libraryproject.web.v1.dtos.library.UpdateLibraryDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepositories libraryRepositories;

    @Autowired
    public LibraryServiceImpl(LibraryRepositories libraryRepositories) {
        this.libraryRepositories = libraryRepositories;
    }

    @Override
    public Collection<Library> getAllLibraries() {
        return libraryRepositories.findAll();
    }

    @Override
    public Library getLibrary(Integer libraryId) {
        return libraryRepositories.findById(libraryId).orElseThrow(() -> {
            throw new LibraryNotFoundException("Library could not be found.");
        });
    }

    @Override
    public Library createLibrary(CreateLibraryDTO createLibraryDTO) {
        Library library = new Library();
        this.validateLibraryName(createLibraryDTO.getLibraryName());
        BeanUtils.copyProperties(createLibraryDTO, library);
        library.activate();
        return (Library) libraryRepositories.saveAndFlush(library);
    }

    @Override
    public Library updateLibrary(Integer libraryId, UpdateLibraryDTO updateLibraryDTO) {
        Library library = getLibrary(libraryId);
        this.validateLibraryName(library.getLibraryName());
        BeanUtils.copyProperties(updateLibraryDTO, library);
        return (Library) this.libraryRepositories.saveAndFlush(library);
    }

    @Override
    public void deleteLibrary(Integer libraryId) {
        Library library = getLibrary(libraryId);
        this.libraryRepositories.delete(library);
    }

    @Override
    public void activateLibrary(Integer libraryId) {
        Library library = getLibrary(libraryId);
        if (library.isActive()){
            throw new ResourceIllegalStateException("Library is already activated.");
        } else {
            library.activate();
            this.libraryRepositories.saveAndFlush(library);
        }
     }

    @Override
    public void deactivateLibrary(Integer libraryId) {
        Library library = getLibrary(libraryId);
        if (!library.isActive()){
            throw new ResourceIllegalStateException("Library is already deactivated.");
        } else {
            library.deactivate();
            this.libraryRepositories.saveAndFlush(library);
        }
    }

    private void validateLibraryName(String libraryName){
        if (Objects.isNull(libraryName) || libraryName.isEmpty()){
            throw new ResourceIllegalStateException("Library name must be specified.");
        }
    }
}
