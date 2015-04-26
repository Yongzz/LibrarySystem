package za.ac.cput.LibrarySystem.domain.Impl;

/**
 * Created by student on 2015/04/17.
 */
//@Entity
public class Member {
   /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private Long id;
    private String member_id;
    private String firstName;
    private String lastName;
    private Address address;

    private Member(){}
    public Member(Builder builder){
        member_id = builder.member_id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        address = builder.address;
    }
    public Long getId() {
        return id;
    }

    public String getMember_id() {
        return member_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public static class Builder{
        private String member_id;
        private String firstName;
        private String lastName;
        private Address address;

        public Builder(String value){
            this.member_id = value;
        }
        public Builder firstName(String value){
            this.firstName = value;
            return this;
        }

        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }

        public Builder Address(Address value){
            this.address = value;
            return this;
        }

        public Builder copy(Member value){
            this.member_id = value.member_id;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.address = value.address;
            return this;
        }

        public Member build(){
            return new Member(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        return !(id != null ? !id.equals(member.id) : member.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
