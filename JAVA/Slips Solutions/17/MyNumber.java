/*Q1. Define a class MyNumber having one private integer data member. Write a parameterized 
constructor to initialize to a value. Write isOdd() to check given number is odd or not. Use command 
line argument to pass a value to the object. [10 Marks]  */

public class MyNumber {
    private int number;

    public MyNumber(int number) {
        this.number = number;
    }

    public boolean isOdd() {
        return number % 2 != 0;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            int value = Integer.parseInt(args[0]);
            MyNumber myNumber = new MyNumber(value);
            System.out.println("Is the number odd? " + myNumber.isOdd());
        } else {
            System.out.println("Please provide a number as a command line argument.");
        }
    }
}