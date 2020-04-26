package by.bsuir.vtb.repository.user;

import by.bsuir.vtb.repository.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByLogin(String login);
}
