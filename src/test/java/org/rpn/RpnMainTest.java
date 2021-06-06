package org.rpn;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for RpnMain.
 */
public class RpnMainTest
{
    @Test
    public void plusOperator()
    {
        Calculator calculator = new Calculator();
        Result result = calculator.compute("3 2 +");
        assertThat(result.getList(), contains(5.0));

        Printer printer = new DefaultPrinter();
        assertEquals("Stack: 5", printer.print(result));
    }

    @Test
    public void MinusOperator()
    {
        Calculator calculator = new Calculator();
        Result result = calculator.compute( "3 2 -");
        assertThat(result.getList(), contains(1.0));

        Printer printer = new DefaultPrinter();
        assertEquals("Stack: 1", printer.print(result));
    }

    @Test
    public void MultiplyOperator()
    {
        Calculator calculator = new Calculator();
        Result result = calculator.compute("3 2 *");
        assertThat(result.getList(), contains(6.0));

        Printer printer = new DefaultPrinter();
        assertEquals("Stack: 6", printer.print(result));
    }

    @Test
    public void DivideOperator()
    {
        Calculator calculator = new Calculator();
        Result result= calculator.compute( "3 2 /");
        assertThat(result.getList(), contains(1.5));

        Printer printer = new DefaultPrinter();
        assertEquals("Stack: 1.5", printer.print(result));
    }


    @Test
    public void SqrtOperator()
    {
        Calculator calculator = new Calculator();
        Result result= calculator.compute( "9 sqrt");
        assertThat(result.getList(), contains(3.0));

        Printer printer = new DefaultPrinter();
        assertEquals("Stack: 3", printer.print(result));
    }

    /*
    Example 1
    5 2
    stack: 5 2
     */
    @Test
    public void TestExample1()
    {
        Calculator calculator = new Calculator();
        Printer printer = new DefaultPrinter();

        assertEquals("Stack: 5 2", printer.print(calculator.compute("5 2")));
    }

    /*
        Example 2
        2 sqrt
        stack: 1.4142135623
        clear 9 sqrt
        stack: 3
     */
    @Test
    public void TestExample2()
    {
        Calculator calculator = new Calculator();
        Printer printer = new DefaultPrinter();

        assertEquals("Stack: 1.4142135624", printer.print(calculator.compute("2 sqrt")));
        assertEquals("Stack: 3", printer.print(calculator.compute("clear 9 sqrt")));
    }

    /*
        Example 3
        5 2 -
        stack: 3
        3 -
        stack: 0
        clear
        stack:
     */
    @Test
    public void TestExample3()
    {
        Calculator calculator = new Calculator();
        Printer printer = new DefaultPrinter();

        assertEquals("Stack: 3", printer.print(calculator.compute("5 2 -")) );
        assertEquals("Stack: 0", printer.print(calculator.compute("3 -")));
        assertEquals("Stack: ", printer.print(calculator.compute("clear")));
    }

    /*
    Example 4
    5 4 3 2
    stack: 5 4 3 2
    undo undo *
    stack: 20
    5 *
    stack: 100
    undo
    stack: 20 5
 */
    @Test
    public void TestExample4()
    {
        Calculator calculator = new Calculator();
        Printer printer = new DefaultPrinter();

        assertEquals("Stack: 5 4 3 2", printer.print(calculator.compute("5 4 3 2")));
        assertEquals("Stack: 20", printer.print(calculator.compute("undo undo *")));
        assertEquals("Stack: 100", printer.print(calculator.compute("5 *")));
        assertEquals("Stack: 20 5", printer.print(calculator.compute("undo")));
    }

    /*
        Example 5
        7 12 2 /
        stack: 7 6
        *
        stack: 42
        4 /
        stack: 10.5
    */
    @Test
    public void TestExample5()
    {
        Calculator calculator = new Calculator();
        Printer printer = new DefaultPrinter();

        assertEquals("Stack: 7 6", printer.print(calculator.compute("7 12 2 /")));
        assertEquals("Stack: 42", printer.print(calculator.compute("*")));
        assertEquals("Stack: 10.5", printer.print(calculator.compute("4 /")));
    }

    /*
    Example 6
    1 2 3 4 5
    stack: 1 2 3 4 5
    *
    stack: 1 2 3 20
    clear 3 4 -
    stack: - 1
   */
    @Test
    public void TestExample6()
    {
        Calculator calculator = new Calculator();
        Printer printer = new DefaultPrinter();

        assertEquals("Stack: 1 2 3 4 5", printer.print(calculator.compute("1 2 3 4 5")));
        assertEquals("Stack: 1 2 3 20", printer.print(calculator.compute("*")));
        assertEquals("Stack: -1", printer.print(calculator.compute("clear 3 4 -")));
    }


    /*
    Example 7
    1 2 3 4 5
    stack: 1 2 3 4 5
    * * * *
    stack: 120
    */
    @Test
    public void TestExample7()
    {
        Calculator calculator = new Calculator();
        Printer printer = new DefaultPrinter();

        assertEquals("Stack: 1 2 3 4 5", printer.print(calculator.compute("1 2 3 4 5")));
        assertEquals("Stack: 120", printer.print(calculator.compute("* * * *")));
    }



    /*
    Example 8
    1 2 3 * 5 + * * 6 5
    operator * (position: 15): insucient parameters
    stack: 11
    (the 6 and 5 were not pushed on to the stack
    due to the previous error)
    */
    @Test
    public void TestExample8()
    {
        Calculator calculator = new Calculator();
        Printer printer = new DefaultPrinter();

        assertEquals("operator * (position: 15): insufficient parameters\nStack: 11",
                printer.print(calculator.compute("1 2 3 * 5 + * * 6 5")));
    }
}
