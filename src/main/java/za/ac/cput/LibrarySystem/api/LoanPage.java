package za.ac.cput.LibrarySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.LibrarySystem.domain.Impl.Librarian;
import za.ac.cput.LibrarySystem.domain.Impl.Loan;
import za.ac.cput.LibrarySystem.domain.Impl.Member;
import za.ac.cput.LibrarySystem.services.LoanServices;

import java.util.List;

/**
 * Created by Yongama on 2015-05-17.
 */
@RestController
@RequestMapping(value = "/loan/**")
public class LoanPage {
    @Autowired
    LoanServices services;

    @RequestMapping(value = "/loans",method = RequestMethod.GET)
    List<Loan> getLoans(){
        return services.getLoans();
    }
    @RequestMapping(value = "/{id/librarian}",method = RequestMethod.GET)
    Librarian getLibrarian(@PathVariable Long ID){
        return services.getLibrarian(ID);
    }
    @RequestMapping(value = "/{id/l}",method = RequestMethod.GET)
    Member getMember(@PathVariable Long ID){
        return services.getMember(ID);
    }
}
