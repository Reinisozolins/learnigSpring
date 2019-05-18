package lv.ozo.learningSpring.service;

import lv.ozo.learningSpring.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void save(User user);
    void delete (User user);

}
