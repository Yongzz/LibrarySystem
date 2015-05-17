//package za.ac.cput.LibrarySystem.api;
/*
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.services.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015-05-10.
 */
/*
@Controller
@RequestMapping("/books")
public class ReserveABook {

    @Autowired private BookService service;

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Book book = service.getBook(id);
        ResponseEntity<Book> responseEntity = new ResponseEntity<Book>(
                book,book == null? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
        return responseEntity;
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public List<ShortBook> getBooks(){
        List<Book> books = service.getBooks();
        List<ShortBook> resources = new ArrayList<ShortBook>(books.size());
        for (Book b : books){
            ShortBook resource = new ShortBook();
            resource.setISBN(b.getISBN());
            resource.setItemType(b.getItemType());
            resource.setSubject(b.getSubject());
            resource.setTittle(b.getTittle());
            Link detail = linkTo(ReserveABook.class).slash(b.getID()).withSelfRel();
            resource.add(detail);
            resources.add(resource);

        }
        return resources;

    }


    public static class ShortBook extends ResourceSupport {
        private String tittle;
        private String subject;
        private String itemType;
        private String ISBN;

        public void setTittle(String tittle) {
            this.tittle = tittle;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public void setISBN(String ISBN) {
            this.ISBN = ISBN;
        }
    }



}*/
