package org.rpn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DefaultPrinter implements Printer{
    @Override
    public String print(List<Double> input) {
        // Print as at most 10 decimal.
        DecimalFormat decimalFormat = new DecimalFormat("###.##########");
        List<String> outputList = new ArrayList<String>();
        for (Double num: input) {
            outputList.add(String.valueOf(decimalFormat.format(num)));
        }
        return  "Stack: " + String.join(" ", outputList);
    }
}
