// package jsf.osf.demo.controllers;

// import jsf.osf.demo.entities.Reservation;
// import jsf.osf.demo.requests.ReservationRequest;
// import jsf.osf.demo.services.ReservationService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// @CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},allowedHeaders = {"*"})
// // @CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.POST},allowedHeaders = {"*"} ) 
// @RestController
// @RequestMapping("/reservation")
// public class ReservationController {


//     @Autowired
//     private ReservationService reservationService;

// //    @Autowired
// //    private MailService mailService;



// //    public ReservationController(ReservationService reservationService, MailService mailService) {
// //        this.reservationService = reservationService;
// //        this.mailService = mailService;
// //
// //    }

//     //  @CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.POST},allowedHeaders = {"*"})
//     @PostMapping
//     public Reservation ajouterReservation(@RequestBody ReservationRequest reservation) throws Exception{

//         return reservationService.ajouterReservation(reservation) ;

//     }

//     @PutMapping
//     public Reservation modifierReservation(@RequestBody Reservation reservation) throws Exception{

//         return reservationService.modifierReservation(reservation);
//     }

//     @GetMapping
//     public List<Reservation> allReservations() throws Exception{
//         return reservationService.allReservations();
//     }

//     @GetMapping("/{id}")
//     public Reservation getReservationById(@PathVariable Long id) throws Exception{

//         return reservationService.getReservationById(id);
//     }

//     @DeleteMapping
//     public boolean suprimerReservation(Long id) throws Exception{

//         return reservationService.suprimerReservation(id);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Reservation> confirmerReservation(@PathVariable Long id) throws Exception{

//         Reservation reservation = reservationService.confirmerReservation(id);
//         return new ResponseEntity<>(reservation, HttpStatus.ACCEPTED);
//     }

//     @PutMapping("/annuler/{id}")
//     public ResponseEntity<Object> annulerReservation(@PathVariable Long id) throws Exception
//     {
//         return new ResponseEntity<>(reservationService.annulerReservation(id) , HttpStatus.ACCEPTED);
//     }



// }


package jsf.osf.demo.controllers;

import jsf.osf.demo.entities.Reservation;
import jsf.osf.demo.requests.ReservationRequest;
import jsf.osf.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = {"*"})
//@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = {"Content-Type","xyz"})
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

//    @Autowired
//    private MailService mailService;



//    public ReservationController(ReservationService reservationService, MailService mailService) {
//        this.reservationService = reservationService;
//        this.mailService = mailService;
//
//    }

    @PostMapping("/client")
    public ResponseEntity<Reservation> ajouterReservation(@RequestBody ReservationRequest reservation) throws Exception {
        System.out.println("#####################"); 
        System.out.println(reservation.getAdresseClient());
        Reservation addedReservation = reservationService.ajouterReservation(reservation);
        return new ResponseEntity<>(addedReservation, HttpStatus.CREATED);
        
    }

    @PutMapping("/client")
    public ResponseEntity<Reservation> modifierReservation(@RequestBody Reservation reservation) throws Exception {
        Reservation modifiedReservation = reservationService.modifierReservation(reservation);
        return new ResponseEntity<>(modifiedReservation, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<Reservation>> allReservations() throws Exception {
        List<Reservation> reservations = reservationService.allReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) throws Exception {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Object> supprimerReservation(@PathVariable Long id) throws Exception {
        System.out.println("#####################"); 
        System.out.println(id);
        boolean deleted = reservationService.suprimerReservation(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<Reservation> confirmerReservation(@PathVariable Long id) throws Exception {
        Reservation reservation = reservationService.confirmerReservation(id);
        return new ResponseEntity<>(reservation, HttpStatus.ACCEPTED);
    }

    @PutMapping("/client/annuler/{id}")
    public ResponseEntity<Object> annulerReservation(@PathVariable Long id) throws Exception {
        boolean canceled = reservationService.annulerReservation(id);
        if (canceled) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}