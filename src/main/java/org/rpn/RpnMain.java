package org.rpn;

import java.util.Scanner;

/*
  A tool to compute reverse polish notation. It supports
  1) basic operations + - * / sqrt
  2) functionality clear and undo

  See RpnMainTest for example usages.

  Commandline to run:
  - mvn clean assembly:assembly
  - java -jar RPN-1.0-SNAPSHOT-jar-with-dependencies.jar
 */
public class RpnMain {
    public static void main( String[] args )
    {
        Calculator calculator = new Calculator();
        Printer printer = new DefaultPrinter();

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String inputLine = scanner.nextLine();
                if ("exit".equals(inputLine)) {
                    break;
            }
            // Parse the input and compute the result.
            Result result = calculator.compute(inputLine);
            // Print the result in specified format.
            String outputPrint = printer.print(result);
            System.out.println(outputPrint);
        }
    }
}
