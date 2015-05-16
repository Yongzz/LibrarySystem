package za.ac.cput.LibrarySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.services.BookService;

import java.util.List;

/**
 * Created by Yongama on 2015-05-10.
 */
public class ReserveABook {
    @Autowired
    private BookService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Book> getBooks(@PathVariable Long id) {
        return service.getBooks();
    }



}
