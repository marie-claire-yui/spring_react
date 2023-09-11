package jsf.osf.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Sejour implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String description;
    private String image1;
    private String image2;

    @OneToMany(mappedBy = "sejour", cascade = CascadeType.REMOVE )
    @JsonBackReference
    private List<Reservation> reservations;

}
