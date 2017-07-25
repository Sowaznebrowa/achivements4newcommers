package login.controller;

import login.model.User;
import login.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveUser {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    private void saveUser(User user) {
        userRepository.save(user);
    }
    @RequestMapping(value = "/createuser", method = RequestMethod.GET)
    public String greeting() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setEmail("asdasd");
        saveUser(user);
        System.out.print("UserCreated");
        return "greeting";
    }
}
