package org.rpn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DefaultPrinter implements Printer{
    @Override
    public String print(Result result) {
        // Print as at most 10 decimal.
        DecimalFormat decimalFormat = new DecimalFormat("###.##########");
        List<String> outputList = new ArrayList<String>();
        for (Double num: result.getList()) {
            outputList.add(String.valueOf(decimalFormat.format(num)));
        }
        String output =  "Stack: " + String.join(" ", outputList);
        // Print error is there is any.
        if (result.hasError()) {
            output = result.getError() + "\n" + output;
        }
        return output;
    }
}
