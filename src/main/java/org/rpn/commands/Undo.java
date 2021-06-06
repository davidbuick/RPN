package org.rpn.commands;

import org.apache.commons.lang3.StringUtils;
import org.rpn.Calculator;
import org.rpn.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Undo implements SpecialOperator{
    public void compute(Stack<Double> stack, Stack<String> allTokens) {
        if (stack.empty() || allTokens.empty()) {
            return;
        }
        // If the last token is a number, drop the number from the stack.
        if(StringUtils.isNumeric(allTokens.peek())) {
            stack.pop();
            allTokens.pop();
        } else {
            // If the last token is an operator, create a new token sequence and drop the last operator.
            List<String> tokenList = new ArrayList<String>();
            // Ignore the last token, which is an operator.
            for (int i = 0; i < allTokens.size() - 1; i++) {
                tokenList.add(allTokens.get(i));
            }
            String newInput = String.join(" ", tokenList);

            // Create an Calculator instance to compute the result after undoing the last operator.
            Calculator calculator = new Calculator();
            Result result = calculator.compute(newInput);

            // Use the new stack to replace the current stack.
            stack.clear();
            for (Double d: result.getList()) {
                stack.push(d);
            }
        }
    }
}
