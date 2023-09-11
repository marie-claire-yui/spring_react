package jsf.osf.demo.repositories;

import jsf.osf.demo.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {

    UserApp findUserAppByUsername(String username);
    UserApp findUserAppById(Long id);
    
}
