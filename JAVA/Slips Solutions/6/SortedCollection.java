/*Q1. Accept 'n' integers from the user and store them in a collection. Display them in the sorted order. 
The collection should not accept duplicate elements. (Use a suitable collection). Search for a 
particular element using predefined search method in the Collection framework. [10 Marks]  */

import java.util.*;

public class SortedCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> T = new TreeSet<>();

        System.out.print("Enter how many numbers: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            T.add(sc.nextInt());
        }

        System.out.println("Sorted numbers (no duplicates): " + T);

        System.out.print("Enter number to search: ");
        int key = sc.nextInt();

        if (T.contains(key))
            System.out.println(key + " found in collection.");
        else
            System.out.println(key + " not found in collection.");
    }
}
