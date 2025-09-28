// Q1. Write a program to accept a number from user and generate multiplication table of a number. 

import java.util.Scanner;
public class multiplication_table {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to generate its multiplication table: ");
        int n = sc.nextInt();

        System.out.println("Multiplication table of " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }

        sc.close();
    }
}