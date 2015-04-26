package za.ac.cput.LibrarySystem.domain.Impl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
public class Publisher implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String publisherName;
    private String placeOfPublication;
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books = new ArrayList<Book>();

    private Publisher(){

    }

    public Long getID() {
        return ID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    public Publisher(Builder builder){
        this.publisherName = builder.publisherName;
        this.placeOfPublication = builder.placeOfPublication;
    }
    public static class Builder{
        private Long ID;
        String publisherName;
        String placeOfPublication;

        public Builder ID(Long ID){
            this.ID = ID;
            return this;
        }
        public Builder publisherName(String value){
            this.publisherName = value;
            return this;
        }

        public Builder placeOfPublication(String value){
            this.placeOfPublication = value;
            return this;
        }
        public Publisher build(){
            return new Publisher(this);
        }

        public Builder copy(Publisher value){
            this.publisherName = value.publisherName;
            this.placeOfPublication= value.placeOfPublication;
            return this;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (ID != null ? !ID.equals(publisher.ID) : publisher.ID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "ID=" + ID +
                ", publisherName='" + publisherName + '\'' +
                '}';
    }
}
