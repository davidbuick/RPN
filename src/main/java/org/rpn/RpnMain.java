package org.rpn;

import java.util.List;
import java.util.Scanner;

public class RpnMain {
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        Printer printer = new DefaultPrinter();
        boolean flag = true;

        while(scanner.hasNext()) {
            String inputLine = scanner.nextLine();
                if (inputLine.equals("exit")) {
                    break;
            }
            // Parse the input and compute the result as a list of Double values.
            List<Double> output = calculator.compute(inputLine);
            // Print the Double values in specified format.
            String outputPrint = printer.print(output);
            System.out.println(outputPrint);
        }


    }
}
