package by.tms.calculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Simon Pirko on 2.08.23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private String name;
  private String username;
  private String password;
}
