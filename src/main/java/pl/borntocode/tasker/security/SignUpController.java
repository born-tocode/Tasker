package pl.borntocode.tasker.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.borntocode.tasker.data.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private UserRepository userRepo;
    private PasswordEncoder encoder;

    public SignUpController(UserRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @GetMapping
    public String registerForm() {
        return "signup";
    }

    @PostMapping
    public String processRegistrationForm(@Valid SignUpForm form, Errors errors) {
        if (errors.hasErrors()){
            return "signup";
        }
        userRepo.save(form.toUser(encoder));
        return "redirect:/signin";
    }
}
