package za.ac.cput.LibrarySystem.repostory;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.LibrarySystem.App;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.repository.BookRepository;

/**
 * Created by Yongama on 2015/05/03.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudBook extends AbstractTestNGSpringContextTests {

    private Long idd;
    @Autowired
    BookRepository rep;
    @Test
    public void testCreate() throws Exception {
       Book item = new Book.Builder("978-1-4080-4863-4")
                .tittle("Database Principles : Fundamentals of Design, implementations, and Management")
                .subject("Database")
                .build();
        rep.save(item);
        idd = item.getID();
        Assert.assertNotNull(item.getSubject());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Book book = rep.findOne(idd);
        Assert.assertEquals("Database", book.getSubject());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Book book = rep.findOne(idd);
        Book newbook = new Book.Builder(book.getISBN())
                .copy(book)
                .subject("Database Development")
                .build();
        rep.save(newbook);
        Assert.assertEquals("Database Development", newbook.getSubject());
        Assert.assertEquals("Database",book.getSubject());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Book book = rep.findOne(idd);
        rep.delete(idd);
        Book b = rep.findOne(idd);
        Assert.assertNull(b);
    }
}
