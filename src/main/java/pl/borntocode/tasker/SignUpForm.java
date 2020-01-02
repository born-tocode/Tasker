package pl.borntocode.tasker;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class SignUpForm {

    private String username;
    private String password;
    private String email;

    public User toUser(PasswordEncoder encoder) {
        return new User(username, encoder.encode(password), email, getTimestamp());
    }

    public Timestamp getTimestamp() {
        return Timestamp.valueOf(LocalDateTime.now());
    }
}