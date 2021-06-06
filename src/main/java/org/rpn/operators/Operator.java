package org.rpn.operators;

import java.util.List;

public interface Operator {
    public abstract double compute(List<Double> inputs);
    public abstract String sign();
    public abstract int parameterNum();
}
