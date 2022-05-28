package pl.java.github;

/**
 Created by xciechan
 on 2022-05-28

 The application displays n numbers of the fibonacci sequence.
 Compares the time of a recursive method and iterative method.
 */

public class Main {

    public static void main(String[] args) {
        int rangeDisplayFibonacci = 45;
        displayComparisonFibonacci(rangeDisplayFibonacci);

    }

    public static  void displayComparisonFibonacci(int range){
        long startTime;
        long stopTime;

        for (int i=0; i<=range; i++) {
            startTime = System.nanoTime();
            System.out.print(i + "_r : " + fibonacciRecursion(i) + " : ");
            stopTime = System.nanoTime();
            System.out.println((stopTime - startTime) + "ns (" + (stopTime - startTime) / 1000000 + "ms)");

            startTime = System.nanoTime();
            System.out.print(i + "_i : " + fibonacciIteration(i) + " : ");
            stopTime = System.nanoTime();
            System.out.println((stopTime - startTime) + "ns (" + (stopTime - startTime) / 1000000 + "ms)");

            System.out.println();
        }

    }

    public static long fibonacciRecursion (int number){
        if (number == 0) return 0;
        if (number == 1) return 1;

        return fibonacciRecursion(number - 1) + fibonacciRecursion(number - 2);
    }

    public static long fibonacciIteration (int number){
        long numberSmaller = 1;
        long numberBigger = 0; // the number is smaller for the first number = 0
        long numberAuxiliary;

        for (int i = 0; i<number; i++){
            numberAuxiliary = numberBigger;
            numberBigger = numberBigger + numberSmaller;
            numberSmaller = numberAuxiliary;
        }

        return numberBigger;
    }

}
