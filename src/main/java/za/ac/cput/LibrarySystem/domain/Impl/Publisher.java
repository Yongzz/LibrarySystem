package za.ac.cput.LibrarySystem.domain.Impl;

import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
public class Publisher implements Serializable{
    Long ID;
    String publisherName;

    public Long getID() {
        return ID;
    }

    public String getPublisherName() {
        return publisherName;
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
