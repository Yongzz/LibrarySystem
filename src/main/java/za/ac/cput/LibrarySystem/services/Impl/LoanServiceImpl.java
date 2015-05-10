package za.ac.cput.LibrarySystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.LibrarySystem.domain.Impl.Loan;
import za.ac.cput.LibrarySystem.repository.LoanRepository;
import za.ac.cput.LibrarySystem.services.LoanService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015-05-10.
 */
public class LoanServiceImpl implements LoanService {
    @Autowired
    LoanRepository repository;
    public List<Loan> getLoans() {
        List<Loan> loanList = new ArrayList<Loan>();
        Iterable<Loan> loans = repository.findAll();
        for (Loan l : loans) {
            loanList.add(l);
        }
        return loanList;
    }
}
