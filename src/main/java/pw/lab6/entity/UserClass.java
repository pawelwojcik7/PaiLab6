package pw.lab6.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;
    private String name;
    private String surname;
    private String login;
    private String password;

    public UserClass(String name, String surname, String login, String password) {
    }
}