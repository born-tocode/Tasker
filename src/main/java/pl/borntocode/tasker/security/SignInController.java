package pl.borntocode.tasker.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.borntocode.tasker.data.UserRepository;

@Controller
@RequestMapping("/signin")
public class SignInController {

    private UserRepository userRepo;
    private PasswordEncoder encoder;

    public SignInController(UserRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @GetMapping
    public String signInForm() {
        return "signin";
    }

}
