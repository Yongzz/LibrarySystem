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
public class Book implements LibraryItem, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String tittle;
    private String subject;
    //private String type;
    @Column(unique = true)
    private String ISBN;
    @ManyToMany
    @JoinColumn(name = "book_id")
    private List<Author> authors = new ArrayList<Author>();
    private Publisher publisher;
    private List<Copy> copies = new ArrayList<Copy>();

    private Book(){}
    public Book(Builder builder){
        ID = builder.ID;
        tittle = builder.tittle;
        subject = builder.subject;
        //type = builder.type;
        ISBN = builder.ISBN;
        publisher = builder.publisher;
        authors = builder.authors;
        copies = builder.copies;

    }

    public String getISBN() {
        return ISBN;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    /*public String getType() {
        return type;
    }*/

    public String getSubject() {
        return subject;
    }

    public String getTittle() {
        return tittle;
    }


    public Long getID() {
        return ID;
    }

    public static class Builder{
        private Long ID;
        private String tittle;
        private String subject;
       // private String type;
        private String ISBN;
        private Publisher publisher;
        private List<Author> authors = new ArrayList<Author>();
        private List<Copy> copies = new ArrayList<Copy>();

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

       /* public Builder type(String value){
            this.type = value;
            return this;
        }*/

        public Builder publisher(Publisher value){
            this.publisher = value;
            return this;
        }

        public Builder authors(List<Author> value){
            this.authors = value;
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
            //this.type = value.type;
            this.ISBN = value.ISBN;
            this.publisher = value.publisher;
            this.authors = value.authors;
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
