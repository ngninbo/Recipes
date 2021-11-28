package recipes.service;

import recipes.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);
    void save(User user);
}
