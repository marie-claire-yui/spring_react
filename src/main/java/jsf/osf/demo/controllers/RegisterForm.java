package jsf.osf.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  @AllArgsConstructor @NoArgsConstructor @Builder
public class RegisterForm {

    private String username;
    private String password;
    private String repassword;

}
