package za.ac.cput.LibrarySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.services.BookService;

import java.util.List;

/**
 * Created by Yongama on 2015-05-17.
 */
@RestController
@RequestMapping("/book/**")
public class BookPage {
    @Autowired BookService service;

    @RequestMapping(value = "/allBooks",method = RequestMethod.GET)
    List<Book> getBooks(){

        return service.getBooks();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Copy> getCopies(@PathVariable Long id){
        return service.getCopies(id);
    }


}
