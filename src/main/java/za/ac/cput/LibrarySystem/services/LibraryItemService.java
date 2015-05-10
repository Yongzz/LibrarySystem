package za.ac.cput.LibrarySystem.services;

import za.ac.cput.LibrarySystem.domain.LibraryItem;

import java.util.List;

/**
 * Created by Yongama on 2015-05-10.
 */
public interface LibraryItemService {
    List<LibraryItem> getItems();
}
