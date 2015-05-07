package za.ac.cput.LibrarySystem.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by Yongama on 2015-05-06.
 */
@MappedSuperclass
public abstract class LibraryItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long ID;
    protected String tittle;
    protected String subject;
    protected String itemType;


    public String getTittle() {
        return tittle;
    }

    public String getSubject() {
        return subject;
    }

    public String getItemType() {
        return itemType;
    }

    public Long getID() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryItem)) return false;

        LibraryItem item = (LibraryItem) o;

        return !(ID != null ? !ID.equals(item.ID) : item.ID != null);

    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "ID=" + ID +
                ", tittle='" + tittle + '\'' +
                ", itemType='" + itemType + '\'' +
                '}';
    }
}
