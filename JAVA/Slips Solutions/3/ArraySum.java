/*Q1. Write a program to accept the 'n' different numbers from user and store it in array. Also print 
the sum of elements of the array. [10 Marks]  */

import java.util.*;
public class ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to store: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];
        int sum = 0;

        System.out.println("Enter " + n + " different numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
            sum += numbers[i];
        }

        System.out.println("\nElements of the array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println("\nSum of elements: " + sum);

        sc.close();
    }
}