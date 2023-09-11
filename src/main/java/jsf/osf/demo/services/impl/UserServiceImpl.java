package jsf.osf.demo.services.impl;

import jsf.osf.demo.entities.RoleEntity;
import jsf.osf.demo.entities.UserEntity;
import jsf.osf.demo.repositories.RoleRepository;
import jsf.osf.demo.repositories.UserRepository;
import jsf.osf.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserEntity saveUser(UserEntity u) {

        UserEntity check = userRepository.findByUsername(u.getUsername());

        if(check!=null)
            throw new RuntimeException("User Already exist");

        // encrypter le password
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));

        return userRepository.save(u);
    }

    @Override
    public RoleEntity saveRole(RoleEntity r) {

        return roleRepository.save(r);
    }

    @Override
    public void addRoleToUser(String username, String role) {

        UserEntity user = userRepository.findByUsername(username);
        RoleEntity roleUser = roleRepository.findByRoleName(role);

        user.getRoles().add(roleUser);

        userRepository.save(user);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
