package jsf.osf.demo.services;

import jsf.osf.demo.entities.RoleEntity;
import jsf.osf.demo.entities.UserEntity;

public interface UserService {

    public UserEntity saveUser(UserEntity u);
    public RoleEntity saveRole(RoleEntity r);

    public void addRoleToUser(String username, String role);

    public UserEntity findUserByUsername(String username);
}
