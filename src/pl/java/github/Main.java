package pl.java.github;

import java.math.BigInteger;

/**
 Created by xciechan
 on 2022-05-28

 The application displays n numbers of the fibonacci sequence.
 Compares the time of a recursive method and iterative method.

      |  0                ,n=0
 Fn = |  1                ,n=1
      |  F(n-1) + F(n-2)  ,n>1
 */

public class Main {

    public static void main(String[] args) {
        int rangeDisplayFibonacci = 45;
        displayComparisonTimeFibonacci(rangeDisplayFibonacci);

    }

    public static  void displayComparisonTimeFibonacci(int range){
        long startTime, stopTime;
        long timeRecursion, timeIteration;

        for (int i=0; i<=range; i++) {
            startTime = System.nanoTime();
            System.out.print(i + "_r : " + fibonacciRecursion(i) + " : ");
            stopTime = System.nanoTime();
            timeRecursion = stopTime - startTime;
            System.out.println(timeRecursion + "ns (" + timeRecursion / 1000000 + "ms)");

            startTime = System.nanoTime();
            System.out.print(i + "_i : " + fibonacciIteration(i) + " : ");
            stopTime = System.nanoTime();
            timeIteration = stopTime - startTime;
            System.out.println(timeIteration + "ns (" + timeIteration / 1000000 + "ms)");

            System.out.println("Time recursion = " + timeRecursion/timeIteration + "x Time iteration");

            System.out.println();
        }
    }

    public static BigInteger fibonacciRecursion (int number){
        if (number == 0) return BigInteger.ZERO;
        if (number == 1) return BigInteger.ONE;

        return fibonacciRecursion(number - 1).add(fibonacciRecursion(number - 2));
    }

    public static BigInteger fibonacciIteration (int number){
        BigInteger numberSmaller = BigInteger.ONE;
        BigInteger numberBigger = BigInteger.ZERO; // the number is smaller for the first number = 0
        BigInteger numberAuxiliary;

        for (int i = 0; i<number; i++){
            numberAuxiliary = numberBigger;
            numberBigger = numberBigger.add(numberSmaller);
            numberSmaller = numberAuxiliary;
        }

        return numberBigger;
    }

}
