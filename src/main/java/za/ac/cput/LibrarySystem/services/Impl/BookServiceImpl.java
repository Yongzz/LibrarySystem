package za.ac.cput.LibrarySystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.repository.BookRepository;
import za.ac.cput.LibrarySystem.services.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015-05-10.
 */
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<Book>();
        Iterable<Book> books = bookRepository.findAll();
        for (Book b : books){
            bookList.add(b);
        }
        return bookList;
    }
}