package za.ac.cput.LibrarySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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
@RequestMapping(value = "/library/**")
public class LoanPage {
    @Autowired
    LoanService services;


    //-------------------Retrieve All Loans--------------------------------------------------------

    @RequestMapping(value = "/loans/", method = RequestMethod.GET)
    public ResponseEntity<List<Loan>> listAllLoans() {
        List<Loan> loans = services.getLoans();
        if(loans.isEmpty()){
            return new ResponseEntity<List<Loan>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Loan>>(loans, HttpStatus.OK);
    }

    //-------------------Retrieve Single Subject--------------------------------------------------------

    @RequestMapping(value = "/loan/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Loan> getLoan(@PathVariable("id") long id) {
        System.out.println("Fetching Loan with id " + id);
        Loan loan = services.findById(id);
        if (loan == null) {
            System.out.println("Loan with id " + id + " not found");
            return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Loan>(loan, HttpStatus.OK);
    }
/*
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
*/
    //-------------------Create a Loan--------------------------------------------------------

    @RequestMapping(value = "/loan/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody Loan loan,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating loan " + loan.toString());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        services.save(loan);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/loan/{id}").buildAndExpand(loan.getID()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Loan --------------------------------------------------------

    @RequestMapping(value = "/loan/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Loan> updateLoan(@PathVariable("id") long id, @RequestBody Loan Loan) {
        System.out.println("Updating Book " + id);

        Loan currentLoan = services.findById(id);

        if (currentLoan==null) {
            System.out.println("Loan with id " + id + " not found");
            return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
        }

        Loan updatedBook = new Loan
                .Builder(currentLoan.getMember(),currentLoan.getLibrarian())
                .copy(currentLoan)
                .build();
        services.update(updatedBook);
        return new ResponseEntity<Loan>(updatedBook, HttpStatus.OK);
    }

    //------------------- Delete a Loan --------------------------------------------------------

    @RequestMapping(value = "/loan/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Loan> deleteLoan(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Loan with id " + id);

        Loan loan = services.findById(id);
        if (loan == null) {
            System.out.println("Unable to delete. Book with id " + id + " not found");
            return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
        }

        services.delete(loan);
        return new ResponseEntity<Loan>(HttpStatus.NO_CONTENT);
    }

}
