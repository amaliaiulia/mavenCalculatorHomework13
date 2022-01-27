package com.endava.calculator;

import com.endava.calculator.Basic.Basic;
import com.endava.calculator.Basic.BasicOperations;
import com.endava.calculator.Expert.Expert;
import com.endava.calculator.Expert.ExpertOperations;

public class TestCalculator {

    public static void main(String[] args) {

        BasicOperations b = new Basic(3);

        System.out.println("Add: ");
        System.out.println(b.add(2,3,4,5));

        System.out.println("Substract: ");
        System.out.println(b.substract(2, -3));

        System.out.println("Multiply: ");
        System.out.println(b.multiply(2,6,3));
        System.out.println(b.multiply(3.5,2.3));

        System.out.println("Divide: ");
        System.out.println(b.divide(39, 6, 3));
        System.out.println(b.divide(10, 3));
        System.out.println(b.divide(5,0));


        ExpertOperations e = new Expert();

        System.out.println("Pow: ");
        System.out.println(e.pow(2,3));
        System.out.println(e.pow(2, -5));

        System.out.println("Root: ");
        System.out.println(e.root(4));
        System.out.println(e.root(10));

        System.out.println("Fact: ");
        System.out.println(e.fact(3));

 /*       System.out.println("Metoda calculate: ");
        System.out.println(e.calculate("2+3"));
        System.out.println(e.calculate("22+33"));
        System.out.println(e.calculate("22.50+33.35"));
        System.out.println(e.calculate("22.50 + 33.35"));
        System.out.println(e.calculate("22.50 + 33.35 +5"));
        System.out.println(e.calculate("-3-5*3"));
*/
        System.out.println("Test cu paranteza: ");
        System.out.println(e.calculate("2 * ( -3 + 2 )"));
        System.out.println(e.calculate("2+(-3-5)*(-7-5)"));
        System.out.println(e.calculate("(3+2)/5*5-(8/2)"));
        //System.out.println(e.calculate("-3+2"));

    }
}
