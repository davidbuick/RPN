package org.rpn;

import org.apache.commons.lang3.StringUtils;
import org.rpn.commands.SpecialOperator;
import org.rpn.commands.SpecialOperatorFactory;
import org.rpn.operators.Operator;
import org.rpn.operators.OperatorFactory;

import java.util.*;

public class Calculator {
    public Result compute(String input) {
        // Position records the number position in the original input. It will be used in the warning of insufficient
        // parameters.
      int position = 0;
      String[] tokens = input.split(" ");
      for (String token: tokens) {
          position += token.length();
          if (StringUtils.isNumeric(token)) {
              stack.push(Double.parseDouble(token));
              allTokens.push(token);
          } else if (isOperator(token)) {
              Operator operator = OperatorFactory.GetOperatorInstance(token);

              // Validate the stack.
              int parameterNum = operator.parameterNum();
              if (stack.size() < parameterNum) {
                  Result result = createOutput(stack);
                  result.setError("operator " + operator.sign() + " (position: " + position + "): insufficient parameters");
                  return result;
              }
              // Construct input for the parameter.
              List<Double> parameters = new ArrayList<Double>();
              for (int i = 0; i < parameterNum; i++) {
                  parameters.add(0, stack.pop());
              }
              // Compute the result via the operator.
              Double result = operator.compute(parameters);

              stack.push(result);
              allTokens.push(token);
          } else if (isSpecialOperator(token)) {
             SpecialOperator specialOperator = SpecialOperatorFactory.GetOperatorInstance(token);
             specialOperator.compute(stack, allTokens);
          }
          // Update position for the whitespace.
          position++;
      }

      return createOutput(stack);
  }

  // Create the output as a list. Note the stack won't be cleared.
  private Result createOutput(Stack<Double> stack) {
      List<Double> output = new ArrayList<Double>();
      for (int i = 0; i < stack.size(); i++) {
          output.add(stack.get(i));
      }
      return new Result(output);
  }

  private boolean isOperator(String input) {
    return validOperators.contains(input);
  }

  private boolean isSpecialOperator(String input) {
    return validSpecialOperators.contains(input);
  }

  private HashSet<String> validOperators = new HashSet<String>(Arrays.asList("+","-","*","/","sqrt"));
  private HashSet<String> validSpecialOperators = new HashSet<String>(Arrays.asList("clear","undo"));
  // Numbers for the current computed result.
  private Stack<Double> stack = new Stack<Double>();
  // All tokens since the beginning of the calculator.
  private Stack<String> allTokens = new Stack<String>();
}
