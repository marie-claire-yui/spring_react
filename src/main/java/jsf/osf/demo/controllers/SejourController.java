package jsf.osf.demo.controllers;


import jsf.osf.demo.entities.Sejour;
import jsf.osf.demo.services.SejourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/sejour")
public class SejourController {


    // l'injection des dependences

    @Autowired
    private SejourService sejourService;

    public SejourController(SejourService sejourService) {
        this.sejourService = sejourService;
    }
    // ajouter un sejour / il faut le POST

    @PostMapping("/admin")
    public ResponseEntity<Sejour>  ajouterSejour(@RequestBody Sejour sejour) throws Exception{

        Sejour sejour1 = sejourService.ajouterSejour(sejour);


        return new ResponseEntity<>(sejour1, HttpStatus.CREATED);
    }


    // recuperer un sejour par ID

    @GetMapping("/admin/{id}")
    public ResponseEntity<Sejour> getSejourById(@PathVariable Long id) throws Exception{

        Sejour sejour   = sejourService.sejouRbyId(id);
        return  new ResponseEntity<>(sejour, HttpStatus.OK) ;
    }


    // recuperer tous les Sejours
    
    @GetMapping("/client")
    public ResponseEntity<List<Sejour>> getAllSejour() throws Exception{

        List<Sejour> sejour = sejourService.allSejours();
        return  new ResponseEntity<>(sejour, HttpStatus.OK) ;
    }


    // update un Sejour

    @PutMapping("/admin")
    public ResponseEntity<Sejour> modifierSejour(@RequestBody Sejour sejour) throws Exception{

        Sejour sejourM = sejourService.modifierSejour(sejour);
        return new ResponseEntity<>(sejourM, HttpStatus.OK);
    }


    // supprimer un sejour par Id

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Object> supprimerSejourById(@PathVariable Long id) throws Exception
    {
        Boolean sejour = sejourService.suprimerSejour(id);
    return new ResponseEntity<>(sejour, HttpStatus.OK);
    }
}