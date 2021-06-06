package org.rpn.operators;

import java.util.List;

public class Sqrt implements Operator{
    @Override
    public double compute(List<Double> inputs) {
        return Math.sqrt(inputs.get(0));
    }

    @Override
    public int parameterNum() {
        return 1;
    }

    @Override
    public String sign() {
        return "sqrt";
    }
}
