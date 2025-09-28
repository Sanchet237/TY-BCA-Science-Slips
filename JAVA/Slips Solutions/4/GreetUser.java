/* Q1. Write a program to accept the user name and greet the user by name. 
Before displaying the user's name, convert it to upper case letters.*/

import java.util.*;

public class GreetUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        name = name.toUpperCase();

        System.out.println("Hello, " + name + ", nice to meet you!");

        sc.close();
    }
}
