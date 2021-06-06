package org.rpn.commands;

/*
   Factory to make instance of SpecialOperator based the input string.
 */
public class SpecialOperatorFactory {
    public static SpecialOperator GetOperatorInstance(String operator) {
        if(operator.equals("clear")) {
            return new Clear();
        } else if(operator.equals("undo")) {
            return new Undo();
        }
        throw new IllegalArgumentException("Invalid special operator " + operator);
    }
}
