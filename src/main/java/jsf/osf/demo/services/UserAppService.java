package jsf.osf.demo.services;


import jsf.osf.demo.entities.UserApp;

import java.util.List;

public interface UserAppService {

    UserApp ajouterUser(UserApp userApp) throws Exception;

    UserApp modifierUser(UserApp userApp) throws Exception;

    UserApp getUserById(Long id) throws Exception;

    List<UserApp> getAllUsers() throws Exception;

    boolean supprimerUserById(Long id) throws  Exception;

}
