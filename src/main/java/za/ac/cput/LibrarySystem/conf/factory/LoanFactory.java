package za.ac.cput.LibrarySystem.conf.factory;

import za.ac.cput.LibrarySystem.domain.Impl.Librarian;
import za.ac.cput.LibrarySystem.domain.Impl.Loan;
import za.ac.cput.LibrarySystem.domain.Impl.Member;

import java.util.Map;

/**
 * Created by Yongama on 2015-04-26.
 */
public class LoanFactory {
    public static Loan createLoan(Map<String,String> value,Member member,Librarian librarian){
        return new Loan.Builder()
                .loanDate(value.get("loanDate"))
                .dueDate(value.get("dueDate"))
                .member(member)
                .librarian(librarian)
                .build();
    }
}