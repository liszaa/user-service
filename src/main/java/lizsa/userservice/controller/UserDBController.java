package lizsa.userservice.controller;

import lizsa.userservice.model.User;
import lizsa.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserDBController {

    @Autowired
    UserRepository repository;

    @GetMapping("/{name}")
    public User getUserByName(@PathVariable String name) {
        return repository.getUserByName(name);
    }
}
