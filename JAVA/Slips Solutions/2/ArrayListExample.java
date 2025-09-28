/*Q1. Write a program to accept ‘n’ integers from the user & store them in an Array List collection. 
Display the elements of Array List. */

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many integers you want to store: ");
        int n = sc.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        System.out.println("\nElements of ArrayList:");
        Iterator<Integer> itr = numbers.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        sc.close();
    }
}
