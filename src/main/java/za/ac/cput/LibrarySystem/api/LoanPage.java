package za.ac.cput.LibrarySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.LibrarySystem.domain.Impl.*;
import za.ac.cput.LibrarySystem.model.BookResource;
import za.ac.cput.LibrarySystem.model.LoanResource;
import za.ac.cput.LibrarySystem.services.LoanService;

import java.util.ArrayList;
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
    @RequestMapping(value = "/all_loans",method = RequestMethod.GET)
    public List<LoanResource> getBooks(){
        List<Loan> loans = services.getLoans();
        List<LoanResource> resources = new ArrayList<>(loans.size());

        for (Loan loan : loans) {
            LoanResource resource = new LoanResource.Builder(loan.getMember(),loan.getLibrarian())
                    .copy(loan.getCopy())
                    .dueDate(loan.getDueDate())
                    .loanDate(loan.getLoanDate())
                    .resID(loan.getID())
                    .build();
            Link link = new
                    Link("http://localhost:8080/loan/"+resource.getresID()+"/librarian")
                    .withRel("booker");
            Link link1 = new
                    Link("http://localhost:8080/loan/"+resource.getresID()+"/member")
                    .withRel("booker");
            Link link2 = new
                    Link("http://localhost:8080/loan/"+resource.getresID()+"/copy")
                    .withRel("booker");
            resource.add(link);
            resource.add(link1);
            resource.add(link2);
            resources.add(resource);
        }
        return resources;
    }


}
