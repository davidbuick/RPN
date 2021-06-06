package org.rpn.commands;

import java.util.Stack;

public interface SpecialOperator {
    public void compute(Stack<Double> stack, Stack<String> allTokens);
}
