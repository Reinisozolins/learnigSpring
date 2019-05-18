package lv.ozo.learningSpring.controller;

import lv.ozo.learningSpring.entity.User;
import lv.ozo.learningSpring.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/users")
public class UserRestController {
    private UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {this.userRepository = userRepository;}

    @GetMapping
    public List<User> getUssers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id") Optional<User> userReport) {
        if (!userReport.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userReport.get(), HttpStatus.OK);
    }

    @PostMapping
    public User saveOrUpdate(@RequestBody User user){
        userRepository.save(user);
        return user;
    }



}
