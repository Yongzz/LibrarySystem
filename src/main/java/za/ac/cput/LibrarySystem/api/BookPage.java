package za.ac.cput.LibrarySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.model.BookResource;
import za.ac.cput.LibrarySystem.services.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015-05-17.
 */
@RestController
@RequestMapping(value = "/book/**")
public class BookPage {

    @Autowired BookService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Copy> getCopies(@PathVariable Long id){
        return service.getCopies(id);
    }

    @RequestMapping(value = "/all_books",method = RequestMethod.GET)
    public List<BookResource> getBooks(){
        List<Book> books = service.getBooks();
        List<BookResource> resources = new ArrayList<>(books.size());

        for (Book book : books) {
            BookResource resource = new BookResource.Builder(book.getISBN())
                    .copies(book.getCopies())
                    .authors(book.getAuthor())
                    .tittle(book.getTittle())
                    .publisher(book.getPublisher())
                    .subject(book.getSubject())
                    .resID(book.getID())
                    .build();
            Link link = new
                    Link("http://localhost:8080/book/"+resource.getResID().toString())
                    .withRel("booker");
            resource.add(link);
            resources.add(resource);
        }
        return resources;
    }


}
