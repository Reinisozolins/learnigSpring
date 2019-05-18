package lv.ozo.learningSpring.repository;

import lv.ozo.learningSpring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByEmail(String email);

    List<User> findAllById (String id);

}
