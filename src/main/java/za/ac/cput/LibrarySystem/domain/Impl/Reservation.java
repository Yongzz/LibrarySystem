package za.ac.cput.LibrarySystem.domain.Impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String reservedDate;
    private Member member;
    private Book book;

    private Reservation(){}

    public Reservation(Builder builder){
        reservedDate = builder.reservedDate;
        member = builder.member;
        book = builder.book;
    }

    public Long getId() {
        return id;
    }

    public String getReservedDate() {
        return reservedDate;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public static class Builder{
        private String reservedDate;
        private Member member;
        private Book book;

        public Builder reservedDate(String value){
            this.reservedDate = value;
            return this;
        }

        public Builder member(Member value){
            this.member = value;
            return this;
        }

        public Builder book(Book value){
            this.book = value;
            return this;
        }

        public Builder copy(Reservation res){
            this.reservedDate = res.reservedDate;
            this.member = res.member;
            this.book = res.book;
            return this;
        }

        public Reservation build(){
            return new Reservation(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
