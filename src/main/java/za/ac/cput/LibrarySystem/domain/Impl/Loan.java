package za.ac.cput.LibrarySystem.domain.Impl;

import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
public class Loan implements Serializable {
    Long ID;
    String loanDate;
    String memberID;
    String librarianID;

    private Loan(){}
    public Loan(Builder builder){

        ID = builder.ID;
        loanDate = builder.loanDate;
        memberID = builder.memberID;
        librarianID = builder.librarianID;

    }
    public Long getID() {
        return ID;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getLibrarianID() {
        return librarianID;
    }
    public static class Builder{

        Long ID;
        String loanDate;
        String memberID;
        String librarianID;
        Builder(String librarianID, String memberID){
            this.librarianID = librarianID;
            this.memberID = memberID;
        }

        public Builder ID(Long value){
            this.ID = value;
            return this;
        }

        public Builder loanDate(String value){
            this.loanDate = value;
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

        if (ID != null ? !ID.equals(loan.ID) : loan.ID != null) return false;

        return true;
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
