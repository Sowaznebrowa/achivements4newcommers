package login.service;


import java.util.List;
import login.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class UserService {

    UserRepository userRepository;

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void findUserById(Long id) {
        userRepository.findOne(id);
    }

    public List<User> showEnabledUsers() {
        return (List <User>) userRepository.findAll();
    }



}
