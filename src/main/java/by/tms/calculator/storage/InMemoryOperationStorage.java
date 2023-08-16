package by.tms.calculator.storage;

import by.tms.calculator.entity.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simon Pirko on 2.08.23
 */
public class InMemoryOperationStorage implements OperationStorage {

  private static final List<Operation> operations = new ArrayList<>();

  @Override
  public void save(Operation operation) {
    operations.add(operation);
  }

  @Override
  public List<Operation> findAllByAuthorUsername(String username) {
    return operations.stream()
        .filter(operation -> operation.getAuthor().getUsername().equals(username))
        .toList();
  }
}
