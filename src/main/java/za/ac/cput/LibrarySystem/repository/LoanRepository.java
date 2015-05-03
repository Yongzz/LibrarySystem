package za.ac.cput.LibrarySystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.LibrarySystem.domain.Impl.Loan;

/**
 * Created by Yongama on 2015-05-03.
 */
public interface LoanRepository extends CrudRepository<Loan,Long>{
}
