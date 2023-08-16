package by.tms.calculator.service;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;
import by.tms.calculator.storage.InMemoryOperationStorage;
import by.tms.calculator.storage.MySqlOperationStorage;
import by.tms.calculator.storage.OperationStorage;

import java.util.List;
import java.util.Optional;

/**
 * @author Simon Pirko on 2.08.23
 */
public class OperationService {

  private final OperationStorage operationStorage = new MySqlOperationStorage();

  public Optional<Operation> calculate(double num1, double num2, String type, User author) {
    switch (type) {
      case "sum":
        double v = num1 + num2;
        Operation value = new Operation(num1, num2, type, v, author);
        operationStorage.save(value);
        return Optional.of(value);
      case "sub":
        double v1 = num1 - num2;
        Operation value1 = new Operation(num1, num2, type, v1, author);
        operationStorage.save(value1);
        return Optional.of(value1);
      case "mul":
        double v2 = num1 * num2;
        Operation value2 = new Operation(num1, num2, type, v2, author);
        operationStorage.save(value2);
        return Optional.of(value2);
      case "div":
        double v3 = num1 / num2;
        Operation value3 = new Operation(num1, num2, type, v3, author);
        operationStorage.save(value3);
        return Optional.of(value3);
    }
    return Optional.empty();
  }

  public List<Operation> getHistory(User author) {
    return operationStorage.findAllByAuthorUsername(author.getUsername());
  }
}
