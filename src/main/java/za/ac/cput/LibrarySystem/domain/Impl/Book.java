package za.ac.cput.LibrarySystem.domain.Impl;


import za.ac.cput.LibrarySystem.domain.LibraryItem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Book extends LibraryItem implements Serializable {

   // @Column(unique = true)
    private String ISBN;
    @Embedded
    private Author author;
    @Embedded
    private Publisher publisher;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private List<Copy> copies;

    private Book(){}
    public Book(Builder builder){
        this.ID = builder.ID;
        tittle = builder.tittle;
        copies = builder.copies;
        subject = builder.subject;
        ISBN = builder.ISBN;
        author = builder.author;
        publisher =builder.publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public Author getAuthors() {
        return author;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public static class Builder{
        private Long ID;
        private String tittle;
        private String subject;
        private String ISBN;
        private Author author;
        private List<Copy> copies;
        private Publisher publisher;


        public Builder(String ISBN){
            this.ISBN = ISBN;
        }

        public Builder ID(Long value){
            this.ID = value;
            return this;
        }
        public Builder ISBN(String value){
            this.ISBN = value;
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

        public Builder publisher(Publisher value){
            this.publisher = value;
            return this;
        }

        public Builder authors(Author value){
            this.author = value;
            return this;
        }

        public Builder copies(List<Copy> value){
            this.copies = value;
            return this;
        }

        public Builder copy(Book value){
            this.ID = value.ID;
            this.tittle = value.tittle;
            this.subject = value.subject;
            this.ISBN = value.ISBN;
            this.author = value.author;
            this.publisher = value.publisher;
            this.copies = value.copies;
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
