package by.tms.calculator.storage;

import by.tms.calculator.entity.User;

import java.util.Optional;

/**
 * @author Simon Pirko on 2.08.23
 */
public interface UserStorage {
  void save(User user);
  Optional<User> findByUsername(String username);
}
