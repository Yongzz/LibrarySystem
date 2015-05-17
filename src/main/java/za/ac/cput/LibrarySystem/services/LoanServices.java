package za.ac.cput.LibrarySystem.services;

import za.ac.cput.LibrarySystem.domain.Impl.Librarian;
import za.ac.cput.LibrarySystem.domain.Impl.Loan;
import za.ac.cput.LibrarySystem.domain.Impl.Member;

import java.util.List;

/**
 * Created by Yongama on 2015-05-16.
 */
public interface LoanServices {
    List<Loan> getLoans();
    Librarian getLibrarian(Long ID);
    Member getMember(Long ID);
}
