package org.rpn.operators;

/*
   Factory to make instance of Operator based the input string.
 */
public class OperatorFactory {
    public static Operator GetOperatorInstance(String operator) {
      if(operator.equals("+")) {
          return new Plus();
      } else if(operator.equals("-")) {
          return new Minus();
      } else if(operator.equals("*")) {
          return new Multiply();
      } else if(operator.equals("/")) {
          return new Divide();
      } else if(operator.equals("sqrt")) {
          return new Sqrt();
      }
        throw new IllegalArgumentException("Invalid operator " + operator);
    }
}
