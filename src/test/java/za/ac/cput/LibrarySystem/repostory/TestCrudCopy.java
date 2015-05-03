package za.ac.cput.LibrarySystem.repostory;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.LibrarySystem.App;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.repository.CopyRepository;

/**
 * Created by Yongama on 2015-05-03.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudCopy extends AbstractTestNGSpringContextTests{

    private Long id;
    @Autowired
    CopyRepository repository;
    @Test
    public void testCreate() throws Exception {
        Copy copy = new Copy.Builder("1001")
                .datePurchased("21/05/2000")
                .copy_Notes("Slightly damaged")
                .build();
        repository.save(copy);
        id = copy.getId();
        Assert.assertNotNull(copy.getCopy_Notes());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Copy copy = repository.findOne(id);
        Assert.assertEquals("Slightly damaged",copy.getCopy_Notes());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Copy copy = repository.findOne(id);
        Copy newcopy = new Copy.Builder(copy.getAccessionNumber()).copy(copy).copy_Notes("Badly damaged").build();
        repository.save(newcopy);
        Assert.assertEquals("Badly damaged",newcopy.getCopy_Notes());
        Assert.assertEquals("Slightly damaged",copy.getCopy_Notes());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Copy copy = repository.findOne(id);
        repository.delete(copy);
        Copy c = repository.findOne(id);
        Assert.assertNull(c);
    }
}
