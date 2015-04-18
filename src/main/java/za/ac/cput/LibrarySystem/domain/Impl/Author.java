package za.ac.cput.LibrarySystem.domain.Impl;

import za.ac.cput.LibrarySystem.domain.Person;

import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
public class Author implements Person, Serializable {
    Long ID;
    String lName;
    String fName;


    private Author(){

    }

    public Author(Builder builder){
        ID = builder.ID;
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

    public static class Builder{
        Long ID;
        String lName;
        String fName;

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

        public Author build(){
            return new Author(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (ID != null ? !ID.equals(author.ID) : author.ID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Author{" +
                "ID='" + ID + '\'' +
                ", lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                '}';
    }
}
