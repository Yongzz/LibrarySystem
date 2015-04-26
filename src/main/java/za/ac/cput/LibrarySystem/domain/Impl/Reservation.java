package za.ac.cput.LibrarySystem.domain.Impl;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by student on 2015/04/18.
 */
public class Reservation {
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
}
