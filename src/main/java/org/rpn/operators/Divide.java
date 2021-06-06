package org.rpn.operators;

import java.util.List;

/*
  Operator to compute the result based on the given input.
 */
public class Divide implements Operator{
    @Override
    public double compute(List<Double> inputs) {
        return inputs.get(0) / inputs.get(1);
    }

    @Override
    public int parameterNum() {
        return 2;
    }

    @Override
    public String sign() {
        return "+";
    }
}
