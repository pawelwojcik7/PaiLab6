package pw.lab6.configuration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pw.lab6.dao.UserDao;
import pw.lab6.entity.UserClass;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;

    private final UserDao dao;

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model m) {

        m.addAttribute("user", new UserClass());

        return "register";
    }

    @PostMapping("/register")
    public String registerPagePOST(@ModelAttribute UserClass user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);

        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profilePage(Model m, Principal principal) {

        m.addAttribute("user", dao.findByLogin(principal.getName()));

        return "profile";
    }

    //@GetMapping("/users")
    //definicja metody, która zwróci do widoku users.html listę
    //użytkowników z bd
}
