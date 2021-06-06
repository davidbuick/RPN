package org.rpn.commands;

import java.util.Stack;

public class Clear implements SpecialOperator {
    public void compute(Stack<Double> stack, Stack<String> allTokens) {
        stack.clear();
    }
}
