package za.ac.cput.LibrarySystem.domain.Impl;

import za.ac.cput.LibrarySystem.domain.LibraryItem;

import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
public class Book implements LibraryItem, Serializable {
    Long ID;
    String tittle;
    String subject;
    String type;
    String ISBN;
    String publisher;
    int publishDate;

    private Book(){}
    public Book(Builder builder){
        ID = builder.ID;
        tittle = builder.tittle;
        subject = builder.subject;
        type = builder.type;
        ISBN = builder.ISBN;
        publisher = builder.publisher;
        publishDate = builder.publishDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublishDate() {
        return publishDate;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public String getTittle() {
        return tittle;
    }

    @Override
    public Long getID() {
        return ID;
    }

    public static class Builder{
        Long ID;
        String tittle;
        String subject;
        String type;
        String ISBN;
        String publisher;
        int publishDate;

        public Builder(String ISBN){
            this.ISBN = ISBN;
        }

        public Builder ID(Long value){
            this.ID = value;
            return this;
        }
        public Builder tittle(String value){
            this.tittle = value;
            return this;
        }

        public Builder subject(String value){
            this.subject = value;
            return this;
        }

        public Builder type(String value){
            this.type = value;
            return this;
        }

        public Builder publisher(String value){
            this.publisher = value;
            return this;
        }
        public Builder publishDate(int value){
            this.publishDate = value;
            return this;
        }

        public Book build(){return new Book(this);}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (ID != null ? !ID.equals(book.ID) : book.ID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", tittle='" + tittle + '\'' +
                '}';
    }
}
