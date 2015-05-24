package za.ac.cput.LibrarySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.domain.Impl.Librarian;
import za.ac.cput.LibrarySystem.domain.Impl.Loan;
import za.ac.cput.LibrarySystem.domain.Impl.Member;
import za.ac.cput.LibrarySystem.services.LoanService;

import java.util.List;

/**
 * Created by Yongama on 2015-05-17.
 */

@RestController
@RequestMapping(value = "/loan/**")
public class LoanPage {
    @Autowired
    LoanService services;

    @RequestMapping(value = "/loans", method = RequestMethod.GET)
    public List<Loan> getLoans() {
        return services.getLoans();
    }

    @RequestMapping(value = "/{ID}/librarian", method = RequestMethod.GET)
    public Librarian getLibrarian(@PathVariable Long ID) {
        return services.getLibrarian(ID);
    }
    @RequestMapping(value = "/{ID}/member", method = RequestMethod.GET)
    public Member getMember(@PathVariable Long ID) {
        return services.getMember(ID);
    }
    @RequestMapping(value = "/{ID}/copy", method = RequestMethod.GET)
    public Copy getCopy(@PathVariable Long ID) {
        return services.getCopy(ID);
    }

}
