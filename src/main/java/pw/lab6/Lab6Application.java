package pw.lab6;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import pw.lab6.dao.UserDao;
import pw.lab6.entity.UserClass;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class Lab6Application {

	private final UserDao dao;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Lab6Application.class, args);
	}

	@PostConstruct
	public void init(){
		dao.save(new UserClass("Piotr", "Piotrowski","admin",
				passwordEncoder.encode("admin")));
		dao.save(new UserClass("Ania", "Annowska","ania",
				passwordEncoder.encode("ania")));
	}

}
