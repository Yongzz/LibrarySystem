package za.ac.cput.LibrarySystem.domain.Impl;

import za.ac.cput.LibrarySystem.domain.Person;

import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
public class Librarian implements Person, Serializable {
    Long ID;
    String lName;
    String fName;
    String librarianID;

    private Librarian(){

    }
    Librarian(Builder builder){
        ID = builder.ID;
        librarianID = builder.librarianID;
        lName = builder.lName;
        fName = builder.fName;
    }
    @Override
    public Long getID() {
        return ID;
    }

    @Override
    public String getLName() {
        return lName;
    }

    @Override
    public String getFName() {
        return fName;
    }

    public String getLibrarianID() {
        return librarianID;
    }

    public static class Builder{
        Long ID;
        String librarianID;
        String lName;
        String fName;


        public Builder (String librarianID){
            this.librarianID = librarianID;
        }

        public Builder ID(Long value){
            this.ID = value;
            return this;
        }


        public Builder lName(String value){
            this.lName = value;
            return this;
        }

        public Builder fName(String value){
            this.fName = value;
            return this;
        }

        public Librarian build(){
            return new Librarian(this);
        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Librarian librarian = (Librarian) o;

        if (ID != null ? !ID.equals(librarian.ID) : librarian.ID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "ID=" + ID +
                ", LName='" + lName + '\'' +
                '}';
    }
}
