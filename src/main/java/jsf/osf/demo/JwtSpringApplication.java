package jsf.osf.demo;

import jsf.osf.demo.entities.RoleEntity;
import jsf.osf.demo.entities.UserEntity;
import jsf.osf.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class JwtSpringApplication implements CommandLineRunner {

	@Autowired
	private UserService userService; //?


	public static void main(String[] args) {
		SpringApplication.run(JwtSpringApplication.class, args);
	}


	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){

		return new BCryptPasswordEncoder();
	}


	@Override
	public void run(String... args) throws Exception {





	}
}
