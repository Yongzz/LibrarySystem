package za.ac.cput.LibrarySystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.LibrarySystem.domain.Impl.Librarian;
import za.ac.cput.LibrarySystem.repository.LibrarianRepository;
import za.ac.cput.LibrarySystem.services.LibrarianService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015-05-10.
 */

/*
public class LibrarianServiceImp implements LibrarianService{
    @Autowired
    LibrarianRepository repository;
    public List<Librarian> getLibrarian() {
        List<Librarian> librarianList = new ArrayList<Librarian>();
        Iterable<Librarian> librarians = repository.findAll();
        for (Librarian l : librarians) {
            librarianList.add(l);
        }
        return librarianList;
    }
}*/
