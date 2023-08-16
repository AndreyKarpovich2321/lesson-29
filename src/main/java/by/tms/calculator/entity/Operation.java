package by.tms.calculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author Simon Pirko on 2.08.23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
  private double num1;
  private double num2;
  private String type;
  private double result;
  private User author;
}
