package jsf.osf.demo.services;


import jsf.osf.demo.entities.Sejour;

import java.util.List;

public interface SejourService {


    Sejour ajouterSejour(Sejour sejour) throws Exception;
    Sejour modifierSejour(Sejour sejour) throws Exception;
    List<Sejour> allSejours() throws Exception;
    Sejour sejouRbyId(Long id) throws Exception;
    boolean suprimerSejour(Long id) throws Exception;
}
