package by.tms.calculator.storage;

import by.tms.calculator.entity.Operation;

import java.util.List;

/**
 * @author Simon Pirko on 2.08.23
 */
public interface OperationStorage {
  void save(Operation operation);
  List<Operation> findAllByAuthorUsername(String username);
}
