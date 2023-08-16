package by.tms.calculator.service;

import by.tms.calculator.entity.User;
import by.tms.calculator.storage.InMemoryUserStorage;
import by.tms.calculator.storage.MySqlUserStorage;
import by.tms.calculator.storage.UserStorage;

import java.util.Optional;

/**
 * @author Simon Pirko on 2.08.23
 */
public class UserService {

  private final UserStorage userStorage = new MySqlUserStorage();

  public void create(String name, String username, String password) {
    User user = new User(name, username, password);
    userStorage.save(user);
  }

  public Optional<User> getByUsername(String username) {
    return userStorage.findByUsername(username);
  }
}
