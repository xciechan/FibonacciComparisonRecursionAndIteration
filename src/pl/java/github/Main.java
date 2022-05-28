package pl.java.github;

/**
 Created by xciechan
 on 2022-05-28

 The application displays n numbers of the fibonacci sequence.
 Compares the time of a recursive method and iterative method.
 */

public class Main {

    public static void main(String[] args) {
        for (int i=0; i<=40; i++){
            System.out.println(i + " : " + fibonacciRecursion(i) + " : " + fibonacciIteration(i));
        }

    }

    public static int fibonacciRecursion (int number){
        if (number == 0) return 0;
        if (number == 1) return 1;

        return fibonacciRecursion(number - 1) + fibonacciRecursion(number - 2);
    }

    public static int fibonacciIteration (int number){
        int numberSmaller = 1;
        int numberBigger = 0; // the number is smaller for the first number = 0
        int numberAuxiliary;

        for (int i = 0; i<number; i++){
            numberAuxiliary = numberBigger;
            numberBigger = numberBigger + numberSmaller;
            numberSmaller = numberAuxiliary;
        }

        return numberBigger;
    }


}
