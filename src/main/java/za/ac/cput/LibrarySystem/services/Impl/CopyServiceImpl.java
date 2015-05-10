package za.ac.cput.LibrarySystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.repository.CopyRepository;
import za.ac.cput.LibrarySystem.services.CopyService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015-05-10.
 */
public class CopyServiceImpl implements CopyService {
    @Autowired
    CopyRepository repository;
    public List<Copy> getCopies() {
        List<Copy> copyList = new ArrayList<Copy>();
        Iterable<Copy> copies = repository.findAll();
        for (Copy b : copies){
            copyList.add(b);
        }
        return copyList;
    }
}
