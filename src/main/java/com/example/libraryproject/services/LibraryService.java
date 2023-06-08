package com.example.libraryproject.services;

import com.example.libraryproject.domain.Library;
import com.example.libraryproject.web.v1.dtos.library.CreateLibraryDTO;
import com.example.libraryproject.web.v1.dtos.library.UpdateLibraryDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface LibraryService {
    Collection<Library> getAllLibraries();

    Library getLibrary(Integer libraryId);

    Library createLibrary(CreateLibraryDTO createLibraryDTO);

    Library updateLibrary(Integer libraryId, UpdateLibraryDTO updateLibraryDTO);

    void deleteLibrary(Integer libraryId);

    void activateLibrary(Integer libraryId);

    void deactivateLibrary(Integer libraryId);
}
