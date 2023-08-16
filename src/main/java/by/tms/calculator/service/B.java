package by.tms.calculator.service;

/**
 * @author Simon Pirko on 2.08.23
 */

public class B extends A {
  @Override
  public boolean process(int a) {
    System.out.println(a);
    if(a > 10) {
      return true;
    }

    throw new RuntimeException();
  }
}
