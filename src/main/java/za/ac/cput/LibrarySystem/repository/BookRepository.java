package za.ac.cput.LibrarySystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.LibrarySystem.domain.Impl.Book;

/**
 * Created by Yongama on 2015-05-03.
 */
public interface BookRepository extends CrudRepository<Book,Long> {
   // Book findByCode(String code);
}
