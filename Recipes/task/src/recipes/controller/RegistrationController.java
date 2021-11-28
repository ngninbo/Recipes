package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import recipes.model.User;
import recipes.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Validated
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder encoder;

    @Autowired
    public RegistrationController(UserService userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @PostMapping("/api/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        Optional<User> userFromRepo = userService.findByEmail(user.getEmail());

        if (userFromRepo.isPresent() && encoder.matches(user.getPassword(), userFromRepo.get().getPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setRole("ROLE_USER");
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
