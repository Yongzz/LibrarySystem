package za.ac.cput.LibrarySystem.domain.Impl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String loanDate;
    private String dueDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Loan_id1")
    private Member member;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Loan_id2")
    private Librarian librarian;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Loan_id")
    private List<Copy> copies;

    private Loan(){}
    public Loan(Builder builder){

        ID = builder.ID;
        loanDate = builder.loanDate;
        member = builder.member;
        librarian= builder.librarian;
        copies = builder.copies;
        dueDate = builder.dueDate;


    }
    public Long getID() {
        return ID;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public Member getMember() {
        return member;
    }

    public static class Builder{

        Long ID;
        private String loanDate;
        private String dueDate;
        private Member member;
        private Librarian librarian;
        private List<Copy> copies;

        public Builder(Member member, Librarian librarian){
            this.librarian = librarian;
            this.member = member;
        }

        public Builder ID(Long value){
            this.ID = value;
            return this;
        }

        public Builder loanDate(String value){
            this.loanDate = value;
            return this;
        }
        public Builder dueDate(String value){
            this.dueDate = value;
            return this;
        }

        public Builder member(Member value){
            this.member = value;
            return this;
        }

        public Builder copies(List<Copy>  value){
            this.copies = value;
            return this;
        }

        public Builder librarian(Librarian value){
            this.librarian = value;
            return this;
        }
        public Builder copy(Loan loan){
            this.copies = loan.copies;
            this.loanDate = loan.loanDate;
            this.member = loan.member;
            this.librarian = loan.librarian;
            return this;
        }

        public Loan build() {
            return new Loan(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        return !(ID != null ? !ID.equals(loan.ID) : loan.ID != null);

    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "ID=" + ID +
                ", LoanDate='" + loanDate + '\'' +
                '}';
    }
}
