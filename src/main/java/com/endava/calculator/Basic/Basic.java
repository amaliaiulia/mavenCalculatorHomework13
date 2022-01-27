package com.endava.calculator.Basic;

public class Basic implements BasicOperations {

    protected int decimals;

    public Basic() {
        decimals = 10;
    }

    public Basic(int decimals) {
        this.decimals = decimals;
    }


    @Override
    public long add(int... no) {   // ... -> nr variabil de argumente; se comporta identic cu int[]
        long sum = 0;  //0 este elem neutru la adunare
        for (int n : no) {
            sum = sum + n;  //sum+=n;
        }
        return sum;
    }

    @Override
    public long add(long... no) {
        long sum = 0;  //0 este elem neutru la adunare
        for (long n : no) {
            sum = sum + n;  //sum+=n;
        }
        return sum;
    }

    @Override
    public double add(double... no) {
        double sum = 0;  //0 este elem neutru la adunare
        for (double n : no) {
            sum = sum + n;  //sum+=n;
        }
        return sum;

    }

    @Override
    public int substract(int... no) {
        int result = no[0];  //se initializeaza cu primul element
        for (int i = 1; i < no.length; i++) {
            result = result - no[i];
        }
        return result;
    }

    @Override
    public long substract(long... no) {
        long result = no[0];  //se initializeaza cu primul element
        for (int i = 1; i < no.length; i++) {
            result = result - no[i];
        }
        return result;
    }

    @Override
    public double substract(double... no) {
        double result = no[0];  //se initializeaza cu primul element
        for (int i = 1; i < no.length; i++) {
            result = result - no[i];
        }
        return formatNumber(result);
    }

    @Override
    public long multiply(int... no) {
        long result = 1;  //1 este elem neutru la inmultire
        for (long n : no) {
            result = result * n;  //result*=n;
        }
        return result;
    }

    @Override
    public long multiply(long... no) {
        long result = 1;  //1 este elem neutru la inmultire
        for (long n : no) {
            result = result * n;  //result*=n;
        }
        return result;
    }

    @Override
    public double multiply(double... no) {
        double result = 1;  //1 este elem neutru la inmultire
        for (double n : no) {
            result = result * n;  //result*=n;
        }
        return formatNumber(result);
    }

    @Override
    public double divide(int... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result = result / no[i];
        }
        return formatNumber(result);

    }

    @Override
    public double divide(long... no) {
        double result = no[0];  // se initializeaza cu primul elem
        for (int i = 1; i < no.length; i++) {
            result = result - no[i];
        }
        return formatNumber(result);
    }

    @Override
    public double divide(double... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result = result - no[i];
        }
        return formatNumber(result);
    }

    protected double formatNumber(double n) {
        String s = String.format("%." + decimals + "f", n);
        return Double.parseDouble(s);
    }


}
