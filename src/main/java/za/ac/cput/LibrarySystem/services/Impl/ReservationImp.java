package za.ac.cput.LibrarySystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.LibrarySystem.domain.Impl.Reservation;
import za.ac.cput.LibrarySystem.repository.ReservationRepository;
import za.ac.cput.LibrarySystem.services.ReservationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015-05-10.
 */
public class ReservationImp implements ReservationService {
    @Autowired
    ReservationRepository repository;
    public List<Reservation> getReservationGet() {
        List<Reservation> reservationList = new ArrayList<Reservation>();
        Iterable<Reservation> reservations = repository.findAll();
        for (Reservation r : reservations) {
            reservationList.add(r);
        }

        return reservationList;
    }
}
