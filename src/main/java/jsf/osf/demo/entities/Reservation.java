package jsf.osf.demo.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation implements Serializable {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String nomClient;
    private String prenomClient;
    private String adresseClient;
    private String mailClient;
    private String phoneNumber;

    private boolean isConfirmed;

    private boolean isCanceled;


    @ManyToOne(cascade = CascadeType.DETACH)
//    @JsonBackReference
    private Sejour sejour;

    private Date dateReservation;
    //private Integer user_id;

    private Integer nombrePersonnes;


    @PrePersist
    public void onInsertReservation(){

        this.isConfirmed = false;
        this.isCanceled = false;

    }

}
