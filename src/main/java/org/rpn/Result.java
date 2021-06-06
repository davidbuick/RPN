package org.rpn;

import java.util.List;

public class Result {

    private List<Double> list;
    private String error;

    public Result(List<Double> list, String error) {
        this.list = list;
        this.error = error;
    }

    public Result(List<Double> list) {
        this.list = list;
    }

    public List<Double> getList() {
        return list;
    }

    public void setList(List<Double> list) {
        this.list = list;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
