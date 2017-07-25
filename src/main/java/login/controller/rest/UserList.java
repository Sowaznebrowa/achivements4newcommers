package login.controller.rest;

import java.util.List;
import login.model.User;
import login.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserList {

    private UserService userService;

    @RequestMapping(value = "/admin/userlist", method = RequestMethod.GET)
    public List<User> showAllEnabledUsers() {
        return userService.showEnabledUsers();
    }
}
