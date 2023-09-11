package jsf.osf.demo.controllers;

import jsf.osf.demo.entities.UserEntity;
import jsf.osf.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/register")
    public UserEntity addUser(@RequestBody RegisterForm userForm){


        if(!userForm.getRepassword().equals(userForm.getRepassword()))
            throw new RuntimeException("yOU MUST CONFIRM YOUR PASSWORD");

        UserEntity user = new UserEntity();
        user.setPassword(userForm.getPassword());
        user.setUsername(userForm.getUsername());
        userService.saveUser(user);
        userService.addRoleToUser(userForm.getUsername(), "USER");
        return user;
    }


    @GetMapping("/testToken")
    public String verefierToken(){

        return "Oui le Token ça marche ";
    }
}
