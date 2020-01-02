package pl.borntocode.tasker;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.borntocode.tasker.data.UserRepository;

@Controller
@RequestMapping("/signup")
public class SignUp {

    private UserRepository userRepo;
    private PasswordEncoder encoder;

    public SignUp(UserRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @GetMapping
    public String registerForm() {
        return "signup";
    }

    @PostMapping
    public String processRegistrationForm(SignUpForm form) {
        userRepo.save(form.toUser(encoder));
        return "redirect:/signin";
    }
}
