/*Q1. Write a program to accept a number from the user, if number is zero then throw user defined
 exception ―Number is 0, otherwise display factorial of a number. [10 Marks] */

import java.util.Scanner;

class NumberIsZeroException extends Exception {
    public NumberIsZeroException(String msg) {
        super(msg);
    }
}

public class FactorialExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        try {
            if (n == 0)
                throw new NumberIsZeroException("Number is 0");

            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            System.out.println("Factorial of " + n + " = " + fact);

        } catch (NumberIsZeroException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
