package jsf.osf.demo.repositories;

import jsf.osf.demo.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByRoleName(String roleName);
}
