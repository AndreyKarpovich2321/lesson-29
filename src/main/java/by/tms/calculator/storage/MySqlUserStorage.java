package by.tms.calculator.storage;

import by.tms.calculator.entity.User;

import java.sql.*;
import java.util.Optional;

public class MySqlUserStorage implements UserStorage{
    @Override
    public void save(User user) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "msqlsrvrpss")){
            PreparedStatement ps;

            ps = connection.prepareStatement("INSERT INTO USERS(NAME, USERNAME, PASSWORD) values (?, ?, ?);");
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "msqlsrvrpss")){
            PreparedStatement ps;

            ps = connection.prepareStatement(" SELECT * FROM USERS\n" + "WHERE USERNAME = ? LIMIT 1;");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            User user = new User(rs.getString("NAME"), rs.getString("USERNAME"), rs.getString("PASSWORD"));
            return Optional.of(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
