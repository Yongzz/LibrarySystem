package za.ac.cput.LibrarySystem.repostory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.LibrarySystem.App;
import za.ac.cput.LibrarySystem.repository.LibrarianRepository;

/**
 * Created by Yongama on 2015-05-03.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudLibrarian {
    private Long id;
    @Autowired
    LibrarianRepository repository;

    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testReade() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}
