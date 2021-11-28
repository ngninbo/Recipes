package recipes.persistance;

import org.springframework.data.repository.CrudRepository;
import recipes.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
