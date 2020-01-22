package pl.borntocode.tasker.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.borntocode.tasker.User;

@Data
public class SignUpForm {

    private String username;
    private String password;
    private String email;

    public User toUser(PasswordEncoder encoder) {
        return new User(username, encoder.encode(password), email);
    }
}
