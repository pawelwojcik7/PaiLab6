package pw.lab6.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pw.lab6.dao.UserDao;
import pw.lab6.entity.UserClass;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAuthenticationDetails implements UserDetailsService {

    private final UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        UserClass user = dao.findByLogin(login);
        if (user != null) {
            List<GrantedAuthority> grupa = new ArrayList<>();
            grupa.add(new SimpleGrantedAuthority("normalUser"));
            return new

                    User(
                    user.getLogin(), user.getPassword(),
                    true, true, true, true, grupa);
        } else {
            throw
                    new UsernameNotFoundException("Zły login lub hasło.");
        }
    }
}