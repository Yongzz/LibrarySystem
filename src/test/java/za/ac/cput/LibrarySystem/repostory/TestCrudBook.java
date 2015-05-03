package za.ac.cput.LibrarySystem.repostory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.LibrarySystem.App;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hashcode on 2015/04/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudBook {
    private Long id;
    @Autowired
    BookRepository rep;
    //MemberRepository res;

    @Test
    public void testCreate() throws Exception {
       Book item = new Book.Builder("978-1-4080-4863-441")
                .tittle("Database Principles : Fundamentals of Design, implementations, and Management")
                .subject("Database")
                .build();
        id = item.getID();
        rep.save(item);
        org.junit.Assert.assertNotNull(item.getSubject());
    }



}
