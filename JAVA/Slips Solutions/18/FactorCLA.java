/*Q1. Write a program to print the factors of a n. Accept a n using command line 
argument. [10 Marks] */

public class FactorCLA {
    public static void main(String[] args) {
        if (args.length > 0) {
            int n = Integer.parseInt(args[0]);
            System.out.println("Factors of " + n + " are:");
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                }
            }
        } else {
            System.out.println("Please provide a number as a command line argument.");
        }
    }
}