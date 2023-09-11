package jsf.osf.demo.services;



import jsf.osf.demo.entities.Reservation;
import jsf.osf.demo.requests.ReservationRequest;

import java.util.List;


public interface ReservationService {
    Reservation ajouterReservation(ReservationRequest reservation) throws Exception;
    Reservation modifierReservation(Reservation reservation) throws Exception;
    List<Reservation> allReservations() throws Exception;
    Reservation getReservationById(Long id_coordonnees) throws Exception;
    boolean suprimerReservation(Long id_coordonnees) throws Exception;

    Reservation confirmerReservation(Long idReservation) throws  Exception;

    boolean annulerReservation(Long idReservation) throws Exception;
}
