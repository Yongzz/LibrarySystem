package za.ac.cput.LibrarySystem.services;

import za.ac.cput.LibrarySystem.domain.Impl.Loan;

import java.util.List;

/**
 * Created by Yongama on 2015-05-10.
 */
public interface LoanService {
    List<Loan> getLoans();
}
