package by.tms.calculator.storage;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySqlOperationStorage implements OperationStorage{
    @Override
    public void save(Operation operation) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "msqlsrvrpss")){
            PreparedStatement ps;

            ps = connection.prepareStatement("INSERT INTO OPERATIONS(FIRST_VALUE, SECOND_VALUE, TYPE, RESULT, AUTHOR) values (?, ?, ?, ?, ?);");
            ps.setDouble(1, operation.getNum1());
            ps.setDouble(2, operation.getNum2());
            ps.setString(3, operation.getType());
            ps.setDouble(4, operation.getResult());
            ps.setString(5, operation.getAuthor().getUsername());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Operation> findAllByAuthorUsername(String username) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "msqlsrvrpss")){
            PreparedStatement ps;
            List<Operation> operations = new ArrayList<>();
            ps = connection.prepareStatement(" SELECT * FROM OPERATIONS\n" + "WHERE AUTHOR = ? ;");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Operation operation = new Operation(rs.getDouble("FIRST_VALUE"), rs.getDouble("SECOND_VALUE"),
                        rs.getString("TYPE"), rs.getDouble("RESULT"), new User("", rs.getString("AUTHOR"), ""));
                operations.add(operation);
            }
            return operations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
