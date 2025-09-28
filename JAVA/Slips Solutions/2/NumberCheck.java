/*Q2. Define a class MyNumber having one private integer data member. Write a default constructor 
initialize it to 0 and another constructor to initialize it to a value. Write methods isNegative, 
isPositive, isOdd, iseven. Use command line argument to pass a value to the object and perform 
the above operations. */

import java.util.*;     

class MyNumber {
    private int number;

    public MyNumber() {
        this.number = 0;
    }

    public MyNumber(int number) {
        this.number = number;
    }

    public boolean isNegative() {
        return number < 0;
    }

    public boolean isPositive() {
        return number > 0;
    }

    public boolean isOdd() {
        return number % 2 != 0;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }
}

public class NumberCheck {
    public static void main(String[] args) {
        if (args.length > 0) {
            int value = Integer.parseInt(args[0]);
            MyNumber myNumber = new MyNumber(value);

            System.out.println("Is Negative: " + myNumber.isNegative());
            System.out.println("Is Positive: " + myNumber.isPositive());
            System.out.println("Is Odd: " + myNumber.isOdd());
            System.out.println("Is Even: " + myNumber.isEven());
        } else {
            System.out.println("Please provide a number as a command line argument.");
        }
    }
}