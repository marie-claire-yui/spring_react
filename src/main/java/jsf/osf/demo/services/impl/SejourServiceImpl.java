package jsf.osf.demo.services.impl;


import jsf.osf.demo.entities.Sejour;
import jsf.osf.demo.exceptions.ErrorMessages;
import jsf.osf.demo.exceptions.NotFoundException;
import jsf.osf.demo.repositories.SejourRepository;
import jsf.osf.demo.services.SejourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SejourServiceImpl implements SejourService {


    @Autowired
    private SejourRepository sejourRepository;

    public SejourServiceImpl(SejourRepository sejourRepository) {
        this.sejourRepository = sejourRepository;
    }


    @Override
    public Sejour ajouterSejour(Sejour sejour) {

 
        return  sejourRepository.save(sejour);
    }

    @Override
    public Sejour modifierSejour(Sejour sejour) throws Exception{

        Sejour dbSejour = sejourRepository.findById(sejour.getId()).orElse(null);
        if(dbSejour !=null ){

            dbSejour.setNom(sejour.getNom());
            dbSejour.setDescription(sejour.getDescription());
            dbSejour.setImage1(sejour.getImage1());
            dbSejour.setImage2(sejour.getImage2());

            return sejourRepository.save(dbSejour);
        }

       throw  new NotFoundException(ErrorMessages.NOT_FOUND.getMessage());
    }

    @Override
    public List<Sejour> allSejours() {

    List<Sejour> sejours = sejourRepository.findAll();
        return sejours;
    }

    @Override
    public Sejour sejouRbyId(Long id) {
        return sejourRepository.findById(id).orElse(null);
    }

    @Override
    public boolean suprimerSejour(Long id) {

        Sejour sejour = sejourRepository.findById(id).orElse(null);

        if (sejour!=null){
            sejourRepository.delete(sejour);
            return true;
        }

        return false;
    }



}
