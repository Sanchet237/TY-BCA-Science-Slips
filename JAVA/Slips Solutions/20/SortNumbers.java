/*Q1. Write a program to accept 3 numbers using command line argument. Sort and display the 
numbers. [10 Marks] */

import java.util.Arrays;

public class SortNumbers {
    public static void main(String[] a) {
        if (a.length < 3) {
            System.out.println("Enter 3 numbers as command line arguments.");
            return;
        }

        int n1 = Integer.parseInt(a[0]);
        int n2 = Integer.parseInt(a[1]);
        int n3 = Integer.parseInt(a[2]);

        int arr[] = {n1, n2, n3};
        Arrays.sort(arr);

        System.out.println("Sorted numbers:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
