package pw.lab6.dao;

import org.springframework.data.repository.CrudRepository;
import pw.lab6.entity.UserClass;

public interface UserDao extends CrudRepository<UserClass, Integer> {
    public UserClass findByLogin(String login);
}
