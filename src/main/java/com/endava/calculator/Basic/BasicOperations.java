package com.endava.calculator.Basic;

public interface BasicOperations {

    abstract long add(int... no);
    abstract long add(long... no);
    abstract double add(double... no);

    abstract int substract(int... no);
    abstract long substract(long... no);
    abstract double substract(double... no);


    abstract long multiply(int... no);
    abstract long multiply(long... no);
    abstract double multiply(double... no);

    abstract double divide(int... no);
    abstract double divide(long... no);
    abstract double divide(double... no);

}
